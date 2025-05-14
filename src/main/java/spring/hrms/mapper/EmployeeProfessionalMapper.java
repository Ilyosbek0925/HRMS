package spring.hrms.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import spring.hrms.DTO.request.EmployeeProfessionalRequest;
import spring.hrms.DTO.response.EmployeeProfessionalResponse;
import spring.hrms.entity.employee.EmployeePersonal;
import spring.hrms.entity.employee.EmployeeProfessional;
import spring.hrms.repository.employeeRepo.EmployeePersonalRepo;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EmployeeProfessionalMapper {
private final EmployeePersonalRepo employeePersonalRepo;
    public EmployeeProfessional toEmployeeProfessional(EmployeeProfessionalRequest employeeProfessionalRequest) {
            Optional<EmployeePersonal> byId = employeePersonalRepo.findById(employeeProfessionalRequest.getEmployeeId());
            EmployeeProfessional employeeProfessional = new EmployeeProfessional();
        employeeProfessional.setEmployeePersonal(byId.orElseThrow(()->new RuntimeException("employee not found")));
        employeeProfessional.setEmployeeType(employeeProfessional.getEmployeeType());
        employeeProfessional.setLocation(employeeProfessional.getLocation());
        employeeProfessional.setDepartment(employeeProfessional.getDepartment());
        employeeProfessional.setDesignation(employeeProfessional.getDesignation());
        employeeProfessional.setEmailAddress(employeeProfessional.getEmailAddress());
        employeeProfessional.setUserName(employeeProfessional.getUserName());
        employeeProfessional.setWorkingDays(employeeProfessional.getWorkingDays());
        return employeeProfessional;
    }
public EmployeeProfessionalResponse toEmployeeProfessionalResponse(EmployeeProfessional employeeProfessional,int storageId) {
        return EmployeeProfessionalResponse.builder()
                .employeeType(employeeProfessional.getEmployeeType())
                .location(employeeProfessional.getLocation())
                .designation(employeeProfessional.getDesignation())
                .emailAddress(employeeProfessional.getEmailAddress())
                .userName(employeeProfessional.getUserName())
                .workingDays(employeeProfessional.getWorkingDays())
                .department(employeeProfessional.getDepartment())
                .storageId(storageId)
                .build();
}

}
