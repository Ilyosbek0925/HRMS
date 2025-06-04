package spring.hrms.repository.employeeRepo.document;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.hrms.entity.employee.document.EmployeePhoto;

import java.util.List;
import java.util.Optional;

public interface EmployeePhotoRepo extends JpaRepository<EmployeePhoto,Integer> {
    Optional<EmployeePhoto> findByServerName(String serverName);
}
