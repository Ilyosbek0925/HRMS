package spring.hrms.repository.employeeRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.hrms.entity.employee.EmployeeLeave;

@Repository
public interface EmployeeLeaveRepo extends JpaRepository<EmployeeLeave, Integer> {
}
