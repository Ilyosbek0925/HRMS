package spring.hrms.DTO.request;

import lombok.Value;
import spring.hrms.entity.status.LeaveStatus;
import spring.hrms.entity.status.SalaryStatus;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * DTO for {@link spring.hrms.entity.employee.EmployeeLeave}
 */
@Value
public class EmployeeLeaveRequest {
    LocalDateTime created;
    LocalDateTime modified;
    LocalDate date;
    Duration duration;
    int days;
    String reportingManager;
    LeaveStatus leaveStatus;
    SalaryStatus salaryStatus;
}