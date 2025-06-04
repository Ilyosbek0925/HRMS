package spring.hrms.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import spring.hrms.DTO.AccountAccessDTO;
import spring.hrms.entity.employee.AccountAccess;
import spring.hrms.entity.employee.EmployeePersonal;
import spring.hrms.repository.employeeRepo.EmployeePersonalRepo;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class   EmployeeAccountAccessMapper {
    private final EmployeePersonalRepo employeePersonalRepo;

    public AccountAccess toAccountAccess(AccountAccessDTO accountAccessDTO) {
        AccountAccess accountAccess = new AccountAccess();
        accountAccess.setEmailAddress(accountAccessDTO.getEmailAddress());
        accountAccess.setGitHubId(accountAccessDTO.getGitHubId());
        accountAccess.setSkypeId(accountAccessDTO.getSkypeId());
        accountAccess.setSlackId(accountAccessDTO.getSlackId());
        Optional<EmployeePersonal> byId = employeePersonalRepo.findById(accountAccess.getId());
        accountAccess.setEmployeePersonal(byId.orElseThrow(() -> new RuntimeException("Employee personal not found")));
        return accountAccess;
    }
    public AccountAccessDTO toAccountAccessDTO(AccountAccess accountAccess) {
        AccountAccessDTO accountAccessDTO = new AccountAccessDTO();
        accountAccessDTO.setEmailAddress(accountAccess.getEmailAddress());
        accountAccessDTO.setGitHubId(accountAccess.getGitHubId());
        accountAccessDTO.setSkypeId(accountAccess.getSkypeId());
        accountAccessDTO.setSlackId(accountAccess.getSlackId());
        return accountAccessDTO;
    }
}
