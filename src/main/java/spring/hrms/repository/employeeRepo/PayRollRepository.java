package spring.hrms.repository.employeeRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.hrms.entity.PayRoll;

public interface PayRollRepository extends JpaRepository<PayRoll, Integer> {
}
