package spring.hrms.DTO.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.Value;
import spring.hrms.entity.status.AttendanceStatus;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * DTO for {@link spring.hrms.entity.employee.Attendance}
 */


@Builder
@Data
@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttendanceRequest  {
    LocalDate date;
    LocalTime checkTime;
    LocalTime checkOut;
    LocalTime breakTime;
    LocalTime workingHours;
    AttendanceStatus status;
}