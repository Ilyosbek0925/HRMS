package spring.hrms.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import spring.hrms.DTO.request.AccountAccessRequest;
import spring.hrms.DTO.request.EmployeePersonalRequest;
import spring.hrms.entity.employee.AccountAccess;
import spring.hrms.entity.employee.EmployeePersonal;
import spring.hrms.repository.employeeRepo.EmployeePersonalRepo;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EmployeeAccountAccessMapper {
    private final EmployeePersonalRepo employeePersonalRepo;

    public AccountAccess toAccountAccess(AccountAccessRequest accountAccessRequest) {
        AccountAccess accountAccess = new AccountAccess();
        accountAccess.setEmailAddress(accountAccessRequest.getEmailAddress());
        accountAccess.setGitHubId(accountAccessRequest.getGitHubId());
        accountAccess.setSkypeId(accountAccessRequest.getSkypeId());
        accountAccess.setSlackId(accountAccessRequest.getSlackId());
        Optional<EmployeePersonal> byId = employeePersonalRepo.findById(accountAccess.getId());
        accountAccess.setEmployeePersonal(byId.orElseThrow(() -> new RuntimeException("Employee personal not found")));
        return accountAccess;

    }
}
