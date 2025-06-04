package spring.hrms.controller.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.hrms.DTO.request.EmployeeProfessionalRequest;
import spring.hrms.DTO.response.EmployeeProfessionalResponse;
import spring.hrms.service.employeeService.EmployeeProfessionalService;

@RestController
@RequiredArgsConstructor
@RequestMapping("employee-professional")
public class EmployeeProfessionalController {
    private final EmployeeProfessionalService service;

    @PostMapping("/{storageId}")
    public ResponseEntity<EmployeeProfessionalResponse> addEmployeeProfessional(@PathVariable int storageId, @RequestBody EmployeeProfessionalRequest request) {
        EmployeeProfessionalResponse response = service.addProfessional(storageId, request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeProfessionalResponse> getEmployeeProfessional(@PathVariable Integer employeeId) {
        EmployeeProfessionalResponse response=service.getEmployee(employeeId);
        return  ResponseEntity.ok(response);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeProfessionalResponse> updateEmployeeProfessional(@PathVariable Integer employeeId, @RequestBody EmployeeProfessionalRequest request) {
      EmployeeProfessionalResponse response= service.update(employeeId,request);
      return ResponseEntity.ok(response);
    }

}
