package spring.hrms.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.hrms.DTO.request.EmployeeProfessionalRequest;
import spring.hrms.DTO.response.EmployeeProfessionalResponse;
import spring.hrms.entity.employee.EmployeeProfessional;
import spring.hrms.service.employeeService.EmployeeProfessionalService;

@RestController
@RequiredArgsConstructor
@RequestMapping("employeeProfessional")
public class EmployeeProfessionalController {
    private final EmployeeProfessionalService service;

    @PostMapping("addEmployeeProfessional/{storageId}")
    public ResponseEntity addEmployeeProfessional(@PathVariable int storageId, @RequestBody EmployeeProfessionalRequest request) {
        EmployeeProfessionalResponse response = service.addProfessional(storageId, request);
        return ResponseEntity.ok(response);
    }


}
