package spring.hrms.repository.employeeRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountAccess extends JpaRepository<spring.hrms.entity.employee.AccountAccess,Integer> {
    @Repository
    interface EmployeeDocuments extends JpaRepository<EmployeeAttendance, Integer> {
    }
}
