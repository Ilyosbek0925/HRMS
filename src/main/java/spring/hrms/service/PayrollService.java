package spring.hrms.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import spring.hrms.DTO.request.PayRollDto;
import spring.hrms.DTO.response.DocumentResponse;
import spring.hrms.DTO.response.PayRollResponse;
import spring.hrms.entity.PayRoll;
import spring.hrms.entity.employee.EmployeePersonal;
import spring.hrms.mapper.PayRollMapper;
import spring.hrms.repository.employeeRepo.EmployeePersonalRepo;
import spring.hrms.repository.employeeRepo.PayRollRepository;
import spring.hrms.service.excelService.ExcelExporter;
import spring.hrms.spesification.GenericSpesification;
import spring.hrms.spesification.PayrollSpesification;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PayrollService {
    private final PayRollMapper payRollMapper;
    private final PayRollRepository payRollRepository;
    private final EmployeePersonalRepo employeePersonalRepo;

    public DocumentResponse exportPayRoll() {
        List<PayRoll> all = payRollRepository.findAll();
            List<List<String>>exportFile = new ArrayList<>();
exportFile.add(new ArrayList<>(Arrays.asList("Employee Name","CTC","Salary Per Month","Deduction","Status")));
        for (PayRoll payRoll : all) {
            exportFile.add(
                    new ArrayList<>(Arrays.asList(
                            payRoll.getEmployeePersonal().getFirstName()+"  "+payRoll.getEmployeePersonal().getLastName(),
                            payRoll.getCtc().toString(),
                            payRoll.getSalaryPerMonth().toString(),
                            payRoll.getDeduction().toString(),
                            payRoll.getStatus().toString())));
        }
        byte[] bytes = ExcelExporter.exportToExcel(exportFile, "PayrollExcelFile.xlsx");
        return DocumentResponse.builder()
                .originalName("Payroll Excel File.xlsx")
                .fileType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
                .file(bytes)
                .build();
    }


    public PayRollResponse addPayRoll(PayRollDto payrollDto) {
        PayRoll payRoll = payRollMapper.toPayRoll(payrollDto);
        return payRollMapper.toPayRollResponse(payRollRepository.save(payRoll));
    }

    

    public Page<PayRollResponse> getPayRoll(Pageable payRollPage) {
        Page<PayRoll> all = payRollRepository.findAll(payRollPage);
        return all.map(payRollMapper::toPayRollResponse);
    }


    public PayRollResponse updatePayRoll(int payrollId, PayRollDto payRollDto) {
        PayRoll payRoll = payRollRepository.findById(payrollId).orElseThrow(() -> new EntityNotFoundException("Payroll  not found with id " + payrollId));
        payRoll.setCtc(new BigDecimal(payRollDto.getCtc()));
        payRoll.setDeduction(new BigDecimal(payRollDto.getDeduction()));
        payRoll.setStatus(payRollDto.getStatus());
        EmployeePersonal employeePersonal = employeePersonalRepo.findById(payRollDto.getEmployeeId()).orElseThrow(() -> new EntityNotFoundException("Employee not found with id " + payrollId));
        payRoll.setEmployeeName(employeePersonal.getFirstName()+" "+employeePersonal.getLastName());
        payRoll.setEmployeePersonal(employeePersonal);
        payRoll.setSalaryPerMonth(new BigDecimal(payRollDto.getSalaryPerMonth()));

        return payRollMapper.toPayRollResponse(payRollRepository.save(payRoll));
    }

    public void deletePayRoll(int payrollId) {
        if(payRollRepository.existsById(payrollId)) {
            payRollRepository.deleteById(payrollId);
        }else  {
            throw new EntityNotFoundException("Payroll Id not found with id " + payrollId);
        }
    }

    public List<PayRollResponse> filter(String name, Double monthSalary, String status) {
        Specification<PayRoll> specification = Specification.where(PayrollSpesification.hasPerMonth(monthSalary)).and(PayrollSpesification.hasName(name)).and(GenericSpesification.hasStatus(status));
        return payRollRepository.findAll(specification).stream().map(payRollMapper::toPayRollResponse).collect(Collectors.toList());
    }
}
