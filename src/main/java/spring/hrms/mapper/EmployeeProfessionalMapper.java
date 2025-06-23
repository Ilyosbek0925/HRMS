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
    public EmployeeProfessional toEmployeeProfessional(EmployeeProfessionalRequest employeeProfessionalRequest) {

            EmployeeProfessional employeeProfessional = new EmployeeProfessional();
        employeeProfessional.setEmployeeType(employeeProfessionalRequest.getEmployeeType());
        employeeProfessional.setLocation(employeeProfessionalRequest.getLocation());
        employeeProfessional.setDepartment(employeeProfessionalRequest.getDepartment());
        employeeProfessional.setDesignation(employeeProfessionalRequest.getDesignation());
        employeeProfessional.setEmailAddress(employeeProfessionalRequest.getEmailAddress());
        employeeProfessional.setUserName(employeeProfessionalRequest.getUserName());
        employeeProfessional.setWorkingDays(employeeProfessionalRequest.getWorkingDays());
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
