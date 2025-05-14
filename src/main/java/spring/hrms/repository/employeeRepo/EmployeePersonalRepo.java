package spring.hrms.repository.employeeRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.hrms.entity.employee.EmployeePersonal;

public interface EmployeePersonalRepo extends JpaRepository<EmployeePersonal, Integer> {
}
