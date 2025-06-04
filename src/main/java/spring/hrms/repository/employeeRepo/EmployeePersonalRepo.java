package spring.hrms.repository.employeeRepo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import spring.hrms.DTO.projection.EmployeeProjection;
import spring.hrms.entity.employee.EmployeePersonal;

public interface EmployeePersonalRepo extends JpaRepository<EmployeePersonal, Integer> , JpaSpecificationExecutor<EmployeePersonal> {

    @Query("select new spring.hrms.DTO.projection.EmployeeProjection(pho.downloadUrl,emp.id,emp.firstName,emp.lastName,prof.department,prof.designation,prof.employeeType) from EmployeePersonal emp"
    +" join emp.employeeProfessional prof"
    +" join emp.employeePhoto pho")
    Page<EmployeeProjection>getEmployeeProjections(Pageable pageable) ;
}




