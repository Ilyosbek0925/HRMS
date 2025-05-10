package spring.hrms.repository.employeeRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeAttendance extends JpaRepository<EmployeeAttendance, Integer> {
}
