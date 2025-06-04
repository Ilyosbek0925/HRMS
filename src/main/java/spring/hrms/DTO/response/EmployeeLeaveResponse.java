package spring.hrms.DTO.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Value;
import spring.hrms.entity.status.LeaveStatus;
import spring.hrms.entity.status.SalaryStatus;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * DTO for {@link spring.hrms.entity.employee.EmployeeLeave}
 */
@Value
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeLeaveResponse {
    Integer leaveId;
    LocalDateTime created;
    LocalDateTime modified;
    LocalDate date;
    Duration duration;
    int days;
    String reportingManager;
    LeaveStatus leaveStatus;
}