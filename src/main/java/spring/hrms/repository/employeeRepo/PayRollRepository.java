package spring.hrms.repository.employeeRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import spring.hrms.entity.PayRoll;

public interface PayRollRepository extends JpaRepository<PayRoll, Integer>, JpaSpecificationExecutor<PayRoll> {
}
