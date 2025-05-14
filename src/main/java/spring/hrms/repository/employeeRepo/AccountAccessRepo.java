package spring.hrms.repository.employeeRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.hrms.entity.employee.AccountAccess;

@Repository
public interface AccountAccessRepo extends JpaRepository<AccountAccess,Integer> {

}
