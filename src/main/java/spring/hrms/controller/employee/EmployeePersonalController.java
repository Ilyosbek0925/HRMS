package spring.hrms.controller.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spring.hrms.DTO.ApiResponseDto;
import spring.hrms.DTO.request.EmployeePersonalRequest;
import spring.hrms.DTO.response.EmployeePersonalResponse;
import spring.hrms.entity.status.ResponseStatus;
import spring.hrms.service.document.EmployeePhotoService;
import spring.hrms.service.employeeService.EmployeePersonalService;
import spring.hrms.temporaryStorage.TemporaryStorage;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("employee-personal")
public class EmployeePersonalController {
    private final EmployeePersonalService service;
    private final EmployeePhotoService photoService;

    @PostMapping()
    public ResponseEntity<EmployeePersonalResponse> addEmployeePersonal(@RequestBody EmployeePersonalRequest employeePersonalRequest) {
        EmployeePersonalResponse employeePersonalResponse = service.addEmployeePersonal(employeePersonalRequest);
        return ResponseEntity.ok(employeePersonalResponse);

    }


    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeePersonalResponse> getEmployeePersonal(@PathVariable Integer employeeId) {
        EmployeePersonalResponse response = service.getEmployeePersonal(employeeId);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeePersonalResponse> updateEmployeePersonal(@PathVariable Integer employeeId, @RequestBody EmployeePersonalRequest employeePersonalRequest) {
        EmployeePersonalResponse response = service.updateEmployeePersonal(employeeId, employeePersonalRequest);
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("cancel/{storageId}")
    public ResponseEntity<ApiResponseDto> deleteEmployeePersonal(@PathVariable int storageId) {
        TemporaryStorage.allEmployees.remove(storageId);
        return ResponseEntity.ok(new ApiResponseDto(ResponseStatus.SUCCESS, "cancelled successfully", LocalDateTime.now()));
    }

@DeleteMapping("/{employeeId}")
    public ResponseEntity<ApiResponseDto> deleteEmployeePersonal(@PathVariable Integer employeeId) {
        service.deleteEmployee(employeeId);
        return ResponseEntity.ok(new ApiResponseDto(ResponseStatus.SUCCESS, "deleted successfully", LocalDateTime.now()));
}


}
