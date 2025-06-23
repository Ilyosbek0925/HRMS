package spring.hrms.service.employeeService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.hrms.DTO.AccountAccessDTO;
import spring.hrms.entity.EmployeeAllData;
import spring.hrms.entity.employee.AccountAccess;
import spring.hrms.entity.employee.EmployeePersonal;
import spring.hrms.entity.employee.document.Document;
import spring.hrms.exception.UserNotFoundException;
import spring.hrms.mapper.EmployeeAccountAccessMapper;
import spring.hrms.repository.employeeRepo.AccountAccessRepo;
import spring.hrms.repository.employeeRepo.EmployeePersonalRepo;
import spring.hrms.repository.employeeRepo.EmployeeProfessionalRepo;
import spring.hrms.repository.employeeRepo.document.*;
import spring.hrms.temporaryStorage.TemporaryStorage;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountAccessService {
    private final EmployeeAccountAccessMapper mapper;
    private final AccountAccessRepo accountAccessRepo;
    private final EmployeePhotoRepo employeePhotoRepo;
    private final EmployeePersonalRepo employeePersonalRepo;
    private final EmployeeProfessionalRepo employeeProfessionalRepo;
    private final List<EmployeeAllData> temporaryStorage = TemporaryStorage.allEmployees;
    private final DocumentRepo documentRepo;

    public AccountAccessDTO add(AccountAccessDTO request, int storageId) {
        EmployeePersonal employeePersonal = temporaryStorage.get(storageId).getEmployeePersonal();
        AccountAccess accountAccess = mapper.toAccountAccess(request);
        accountAccess.setEmployeePersonal(employeePersonal);
        employeePersonalRepo.save(employeePersonal);
        AccountAccess save = accountAccessRepo.save(accountAccess);
        employeePhotoRepo.save(temporaryStorage.get(storageId).getPhoto());
        employeeProfessionalRepo.save(temporaryStorage.get(storageId).getEmployeeProfessional());
        documentRepo.saveAll(temporaryStorage.get(storageId).getDocuments());
        return mapper.toAccountAccessDTO(save);
    }

    public AccountAccessDTO getAccountAccess(Integer employeeId) {
        AccountAccess accountAccess = accountAccessRepo.findById(employeeId).orElseThrow(() -> new UserNotFoundException("Employee not found with id: " + employeeId));
        return mapper.toAccountAccessDTO(accountAccess);

    }

    public void update(Integer employeeId, AccountAccessDTO request) {
        Integer id = employeePersonalRepo.findById(employeeId).orElseThrow(() -> new UserNotFoundException("Employee not found with id: " + employeeId)).getAccountAccess().getId();
        AccountAccess accountAccess = mapper.toAccountAccess(request);
        accountAccess.setId(id);
        accountAccessRepo.save(accountAccess);
    }
}
