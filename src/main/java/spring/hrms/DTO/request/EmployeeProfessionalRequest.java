package spring.hrms.DTO.request;

import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.util.Set;
@Getter
@Setter
public class EmployeeProfessionalRequest {
    private Integer employeeId;
    private String userName;
    private String employeeType;
    private String emailAddress;
    private String department;
    private String designation;
    private Set<DayOfWeek> workingDays;
    private String location;
}
