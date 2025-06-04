package spring.hrms.DTO.request;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Value;
import spring.hrms.entity.status.AttendanceStatus;

import java.time.LocalDate;
import java.time.LocalTime;

@Value
@Getter
public class AttendanceUpdateRequest {
    Integer attendanceId;
    LocalDate date;
    LocalTime checkTime;
    LocalTime checkOut;
    LocalTime breakTime;
    LocalTime workingHours;
    AttendanceStatus status;
    Integer employeeId;
}
