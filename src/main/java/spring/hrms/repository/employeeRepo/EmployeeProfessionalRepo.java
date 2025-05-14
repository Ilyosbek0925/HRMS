package spring.hrms.repository.employeeRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.hrms.entity.employee.EmployeeProfessional;

@Repository
public interface EmployeeProfessionalRepo extends JpaRepository<EmployeeProfessional, Integer> {
}
