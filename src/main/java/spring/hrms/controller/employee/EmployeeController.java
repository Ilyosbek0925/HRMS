package spring.hrms.controller.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.hrms.DTO.projection.EmployeeProjection;
import spring.hrms.service.employeeService.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService service;

    @GetMapping
    public ResponseEntity<Page<EmployeeProjection>> getEmployeeProjection(@RequestParam(required = false, defaultValue = "0") Integer page,
                                                                          @RequestParam(required = false, defaultValue = "10") Integer size) {
        Page<EmployeeProjection> all = service.getEmployee(page, size);
        return ResponseEntity.ok(all);
    }


    @GetMapping("filter")
    public ResponseEntity<List<EmployeeProjection>> filter(@RequestParam(required = false) String name,
                                                           @RequestParam(required = false) String department,
                                                           @RequestParam(required = false) String designation,
                                                           @RequestParam(required = false) String type
    ) {
        List<EmployeeProjection> filter = service.filter(name, department, designation, type, null);
        return ResponseEntity.ok(filter);
    }
}
