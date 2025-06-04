package spring.hrms.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import spring.hrms.DTO.request.AttendanceRequest;
import spring.hrms.DTO.request.AttendanceUpdateRequest;
import spring.hrms.DTO.response.AttendanceResponse;
import spring.hrms.entity.employee.Attendance;
import spring.hrms.entity.employee.EmployeePersonal;
import spring.hrms.repository.employeeRepo.EmployeePersonalRepo;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AttendanceMapper {
    private final EmployeePersonalRepo personalRepo;

    public AttendanceRequest toAttendanceDto(Attendance attendance) {
        return AttendanceRequest.builder()
                .date(attendance.getDate())
                .status(attendance.getStatus())
                .breakTime(
                        attendance.getBreakTime()
                )
                .checkOut(attendance.getCheckOut())
                .workingHours(attendance.getWorkingHours())
                .checkTime(attendance.getCheckTime())

                .build();
    }

    public Attendance toAttendance(int employeeId, AttendanceRequest attendanceRequest) {
        Attendance attendance = new Attendance();
        attendance.setDate(attendanceRequest.getDate());
        attendance.setStatus(attendanceRequest.getStatus());
        attendance.setBreakTime(attendanceRequest.getBreakTime());
        attendance.setCheckOut(attendanceRequest.getCheckOut());
        attendance.setWorkingHours(attendanceRequest.getWorkingHours());
        attendance.setCheckTime(attendanceRequest.getCheckTime());
        attendance.setEmployeePersonal(personalRepo.findById(employeeId).orElseThrow(()-> new RuntimeException("Employee not found")));
        return attendance;
    }

    public Attendance toAttendance(AttendanceUpdateRequest attendanceUpdateRequest) {
        Attendance attendance = new Attendance();
        attendance.setDate(attendanceUpdateRequest.getDate());
        attendance.setStatus(attendanceUpdateRequest.getStatus());
        attendance.setBreakTime(attendanceUpdateRequest.getBreakTime());
        attendance.setCheckOut(attendanceUpdateRequest.getCheckOut());
        attendance.setWorkingHours(attendanceUpdateRequest.getWorkingHours());
        attendance.setCheckTime(attendanceUpdateRequest.getCheckTime());
        EmployeePersonal employee = personalRepo.findById(attendanceUpdateRequest.getEmployeeId()).orElseThrow(() -> new RuntimeException("Employee not found"));
        attendance.setEmployeePersonal(employee);
    return attendance;
    }

    public List<Attendance> toAttendanceList(List<AttendanceUpdateRequest> attendanceUpdateRequests) {
        return attendanceUpdateRequests.stream().map(this::toAttendance).toList();
    }


    public AttendanceResponse toAttendanceResponse(Attendance attendance) {
        return AttendanceResponse.builder()
                .date(attendance.getDate())
                .status(attendance.getStatus())
                .breakTime(attendance.getBreakTime())
                .checkOut(attendance.getCheckOut())
                .workingHours(attendance.getWorkingHours())
                .checkTime(attendance.getCheckTime())
                .attendanceId(attendance.getId())
                .build();
    }


public List<AttendanceResponse> toAttendanceResponse(List<Attendance> attendanceUpdateRequests) {
        return attendanceUpdateRequests.stream().map(this::toAttendanceResponse).toList();
}



}
