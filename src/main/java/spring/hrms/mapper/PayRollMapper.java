package spring.hrms.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import spring.hrms.DTO.request.PayRollDto;
import spring.hrms.DTO.response.PayRollResponse;
import spring.hrms.entity.PayRoll;
import spring.hrms.entity.employee.EmployeePersonal;
import spring.hrms.repository.employeeRepo.EmployeePersonalRepo;

import java.math.BigDecimal;
@RequiredArgsConstructor
@Component
public class PayRollMapper {
    private final EmployeePersonalRepo employeePersonalRepo;
    public PayRoll toPayRoll(PayRollDto payRollDto) {
        PayRoll payRoll = new PayRoll();
        try {
            BigDecimal ctc = new BigDecimal(payRollDto.getCtc().trim());
            BigDecimal salaryPerMonth = new BigDecimal(payRollDto.getSalaryPerMonth().trim());
            BigDecimal deduction = new BigDecimal(payRollDto.getDeduction().trim());
        payRoll.setCtc(ctc);
        payRoll.setSalaryPerMonth(salaryPerMonth);
        payRoll.setDeduction(deduction);
        }
        catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        payRoll.setStatus(payRollDto.getStatus());
        payRoll.setEmployeePersonal(employeePersonalRepo.findById(payRollDto.getEmployeeId()).orElseThrow(()->new RuntimeException("Employee is not found")));
        return  payRoll;
    }

    public PayRollResponse toPayRollResponse(PayRoll payRoll) {
        return PayRollResponse.builder()
                .ctc(String.valueOf(payRoll.getCtc()))
                .salaryPerMonth(String.valueOf(payRoll.getSalaryPerMonth()))
                .deduction(String.valueOf(payRoll.getDeduction()))
                .employeeId(payRoll.getEmployeePersonal().getId())
                .payRollId(payRoll.getId())
                .build();
    }
}
