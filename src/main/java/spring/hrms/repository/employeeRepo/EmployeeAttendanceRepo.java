package spring.hrms.repository.employeeRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.hrms.entity.employee.EmployeeAttendance;

@Repository
public interface EmployeeAttendanceRepo extends JpaRepository<EmployeeAttendance, Integer> {
}
