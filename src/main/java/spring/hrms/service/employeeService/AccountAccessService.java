package spring.hrms.service.employeeService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.hrms.DTO.AccountAccessDTO;
import spring.hrms.entity.EmployeeAllData;
import spring.hrms.entity.employee.AccountAccess;
import spring.hrms.mapper.EmployeeAccountAccessMapper;
import spring.hrms.repository.employeeRepo.AccountAccessRepo;
import spring.hrms.repository.employeeRepo.EmployeePersonalRepo;
import spring.hrms.repository.employeeRepo.EmployeeProfessionalRepo;
//import spring.hrms.repository.employeeRepo.archiveDocument.AppointmentLetterRepo;
//import spring.hrms.repository.employeeRepo.archiveDocument.ExperienceLetterRepo;
//import spring.hrms.repository.employeeRepo.archiveDocument.RelivingLetterRepo;
//import spring.hrms.repository.employeeRepo.archiveDocument.SalarySlipRepo;
import spring.hrms.repository.employeeRepo.document.*;
import spring.hrms.temporaryStorage.TemporaryStorage;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountAccessService {
    private final EmployeeAccountAccessMapper mapper;
    private final AccountAccessRepo accountAccessRepo;
//    private final AppointmentLetterRepo appoinmentLetterRepo;
    private final EmployeePhotoRepo employeePhotoRepo;
//    private final ExperienceLetterRepo experienceLetterRepo;
//    private final RelivingLetterRepo relivingLetterRepo;
//    private final SalarySlipRepo salarySlipRepo;
    private final EmployeePersonalRepo employeePersonalRepo;
    private final EmployeeProfessionalRepo employeeProfessionalRepo;
    private List<EmployeeAllData> temporaryStorage = TemporaryStorage.allEmployees;

    public AccountAccessDTO add(AccountAccessDTO request, int storageId) {
        AccountAccess accountAccess = mapper.toAccountAccess(request);
        AccountAccess save = accountAccessRepo.save(accountAccess);
//        appoinmentLetterRepo.save(temporaryStorage.get(storageId).getAppointmentLetter());
//        experienceLetterRepo.save(temporaryStorage.get(storageId).getExperienceLetter());
//        salarySlipRepo.save(temporaryStorage.get(storageId).getSalarySlip());
//        relivingLetterRepo.save(temporaryStorage.get(storageId).getRelivingLetter());
        employeePhotoRepo.save(temporaryStorage.get(storageId).getPhoto());
        employeePersonalRepo.save(temporaryStorage.get(storageId).getEmployeePersonal());
        employeeProfessionalRepo.save(temporaryStorage.get(storageId).getEmployeeProfessional());
        return mapper.toAccountAccessDTO(save);
    }

    public AccountAccessDTO getAccountAccess(Integer employeeId) {
        AccountAccess accountAccess = accountAccessRepo.findById(employeeId).orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + employeeId));
return mapper.toAccountAccessDTO(accountAccess);

    }

    public void update(Integer employeeId, AccountAccessDTO request) {
        Integer id = employeePersonalRepo.findById(employeeId).orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + employeeId)).getAccountAccess().getId();
        AccountAccess accountAccess = mapper.toAccountAccess(request);
        accountAccess.setId(id);
        accountAccessRepo.save(accountAccess);
    }
}
