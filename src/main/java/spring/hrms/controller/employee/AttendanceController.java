package spring.hrms.controller.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.hrms.DTO.ApiResponseDto;
import spring.hrms.DTO.projection.AttendanceProjection;
import spring.hrms.DTO.request.AttendanceRequest;
import spring.hrms.DTO.request.AttendanceUpdateRequest;
import spring.hrms.DTO.response.AttendanceResponse;
import spring.hrms.entity.status.ResponseStatus;
import spring.hrms.service.employeeService.AttendanceService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
@RestController
@RequestMapping("attendance")
@RequiredArgsConstructor
public class AttendanceController {
    private final AttendanceService service;

    @PostMapping("/{employeeId}")
    public ResponseEntity<AttendanceResponse> addAttendance(@PathVariable int employeeId, @RequestBody AttendanceRequest attendanceRequest) {
        AttendanceResponse response = service.add(employeeId, attendanceRequest);
        return ResponseEntity.ok(response);
    }

    @PutMapping("")
    public ResponseEntity<ApiResponseDto> updateAttendance(@RequestBody List<AttendanceUpdateRequest> attendanceUpdateRequests) {
        service.update(attendanceUpdateRequests);
        return ResponseEntity.ok(new ApiResponseDto(ResponseStatus.SUCCESS, "updated successfully", LocalDateTime.now()));
    }

    @GetMapping("by-employee/{employeeId}")
    public ResponseEntity<List<AttendanceResponse>> getAttendanceByEmployeeId(@PathVariable int employeeId) {
        List<AttendanceResponse> employeeAttendances = service.getAllAttendanceByEmployeeId(employeeId);
        return ResponseEntity.ok(employeeAttendances);
    }

    @GetMapping("filter")
    public ResponseEntity<List<AttendanceProjection>> filter(@RequestParam(required = false) String name,
                                                             @RequestParam(required = false)LocalDate minDate,
                                                             @RequestParam(required = false)LocalDate maxDate,
                                                             @RequestParam(required = false)LocalTime minTime,
                                                             @RequestParam(required = false)LocalTime maxTime,
                                                             @RequestParam(required = false)String status
                                                             ) {
        return ResponseEntity.ok(service.filter(name,minDate,maxDate,minTime,maxTime,status));
    }


    @GetMapping()
    public ResponseEntity<Page<AttendanceProjection>> getAllAttendance(@RequestParam(required = false,defaultValue = "0") int page, @RequestParam(required = false,defaultValue = "10") int size) {
        Page<AttendanceProjection> projection = service.getAttendance(page,size);
        return ResponseEntity.ok(projection);
    }

}
