package spring.hrms.DTO.request;

import lombok.Value;
import spring.hrms.entity.employee.CandidateStatus;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link spring.hrms.entity.employee.Candidate}
 */
@Value
public class CandidateDto implements Serializable {
    String name;
    String appliedFor;
    LocalDate appliedDate;
    String email;
    String phone;
    CandidateStatus status;
}