package spring.hrms.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.hrms.DTO.request.EmployeePersonalRequest;
import spring.hrms.DTO.response.EmployeePersonalResponse;
import spring.hrms.entity.employee.EmployeePersonal;
import spring.hrms.service.employeeService.EmployeePersonalService;

@RestController
@RequiredArgsConstructor
@RequestMapping("employeePersonal")
public class EmployeePersonalController{
private final EmployeePersonalService service;

    @PostMapping("addEmployeePersonal")
public ResponseEntity addEmployeePersonal(@RequestBody EmployeePersonalRequest employeePersonalRequest) {
        EmployeePersonalResponse employeePersonalResponse = service.addEmployeePersonal(employeePersonalRequest);
        return ResponseEntity.ok(employeePersonalResponse);

    }




}
