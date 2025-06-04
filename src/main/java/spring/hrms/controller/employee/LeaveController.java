package spring.hrms.controller.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.hrms.DTO.ApiResponseDto;
import spring.hrms.DTO.request.EmployeeLeaveRequest;
import spring.hrms.DTO.response.EmployeeLeaveResponse;
import spring.hrms.entity.status.ResponseStatus;
import spring.hrms.service.LeaveService;
import java.time.LocalDateTime;
import java.util.List;
@RestController
@RequestMapping("leave")
@RequiredArgsConstructor
public class LeaveController {
    private final LeaveService service;

    @PostMapping("/{employeeId}")
    public ResponseEntity<EmployeeLeaveResponse> leaverResponse(@PathVariable int employeeId, @RequestBody EmployeeLeaveRequest employeeLeaveRequest) {
        EmployeeLeaveResponse response = service.addLeave(employeeId, employeeLeaveRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<List<EmployeeLeaveResponse>> getLeave(@PathVariable int employeeId) {
        List<EmployeeLeaveResponse>responseList=service.getLeave(employeeId);
        return  ResponseEntity.status(HttpStatus.OK).body(responseList);
    }

    @PutMapping("/{leaveId}")
    public ResponseEntity<EmployeeLeaveResponse>update(@PathVariable int leaveId, @RequestBody EmployeeLeaveRequest employeeLeaveRequest) {
        EmployeeLeaveResponse response=service.update(leaveId,employeeLeaveRequest);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{leaveId}")
    public ResponseEntity<ApiResponseDto> deleteLeave(@PathVariable int leaveId) {
        service.deleteLeave(leaveId);
        return ResponseEntity.ok(new ApiResponseDto(ResponseStatus.SUCCESS,"deleted successfully", LocalDateTime.now()));

    }


}
