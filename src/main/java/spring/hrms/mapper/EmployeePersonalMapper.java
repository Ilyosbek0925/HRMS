package spring.hrms.mapper;

import org.springframework.stereotype.Component;
import spring.hrms.DTO.request.EmployeePersonalRequest;
import spring.hrms.DTO.response.EmployeePersonalResponse;
import spring.hrms.entity.employee.EmployeePersonal;

@Component
public class EmployeePersonalMapper {
public EmployeePersonal toEmployeePersonal(EmployeePersonalRequest employeePersonalRequest) {
    EmployeePersonal employeePersonal = new EmployeePersonal();
    employeePersonal.setAddress(employeePersonalRequest.getAddress());
    employeePersonal.setCity(employeePersonalRequest.getCity());
    employeePersonal.setEmail(employeePersonalRequest.getEmail());
    employeePersonal.setFirstName(employeePersonalRequest.getFirstName());
    employeePersonal.setLastName(employeePersonalRequest.getLastName());
    employeePersonal.setDateOfBirth(employeePersonalRequest.getDateOfBirth());
    employeePersonal.setGender(employeePersonalRequest.getGender());
    employeePersonal.setMobileNumber(employeePersonalRequest.getMobileNumber());
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
