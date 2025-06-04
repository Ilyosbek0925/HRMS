package spring.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.hrms.entity.employee.EmployeeLeave;
@Repository
public interface LeaveRepository extends JpaRepository<EmployeeLeave,Integer> {
}
