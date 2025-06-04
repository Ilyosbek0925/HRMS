package spring.hrms.DTO.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import spring.hrms.entity.status.AttendanceStatus;

import java.time.LocalDate;
import java.time.LocalTime;
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttendanceResponse {
    Integer attendanceId;
    LocalDate date;
    LocalTime checkTime;
    LocalTime checkOut;
    LocalTime breakTime;
    LocalTime workingHours;
    AttendanceStatus status;
}
