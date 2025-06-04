package spring.hrms.mapper;

import org.springframework.stereotype.Component;
import spring.hrms.DTO.request.EmployeePersonalRequest;
import spring.hrms.DTO.response.EmployeePersonalResponse;
import spring.hrms.entity.employee.EmployeePersonal;

@Component
public class EmployeePersonalMapper {
public EmployeePersonal toEmployeePersonal(EmployeePersonalRequest employeePersonalRequest) {
    EmployeePersonal employeePersonal = new EmployeePersonal();
    employeePersonal.setAddress(employeePersonal.getAddress());
    employeePersonal.setCity(employeePersonal.getCity());
    employeePersonal.setEmail(employeePersonal.getEmail());
    employeePersonal.setFirstName(employeePersonal.getFirstName());
    employeePersonal.setLastName(employeePersonal.getLastName());
    employeePersonal.setDateOfBirth(employeePersonal.getDateOfBirth());
    employeePersonal.setGender(employeePersonal.getGender());
    employeePersonal.setMobileNumber(employeePersonal.getMobileNumber());
    return employeePersonal;
}
public EmployeePersonalResponse toEmployeePersonalResponse(EmployeePersonal employeePersonal) {
    return EmployeePersonalResponse.builder()
            .address(employeePersonal.getAddress())
            .city(employeePersonal.getCity())
            .email(employeePersonal.getEmail())
            .firstName(employeePersonal.getFirstName())
            .lastName(employeePersonal.getLastName())
            .dateOfBirth(employeePersonal.getDateOfBirth())
            .gender(employeePersonal.getGender())
            .mobileNumber(employeePersonal.getMobileNumber())
            .state(employeePersonal.getState())
            .nationality(employeePersonal.getNationality())
            .zipCode(employeePersonal.getZipCode())
            .build();
}






}
