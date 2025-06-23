package spring.hrms.DTO.response;

import lombok.Builder;
import lombok.Value;
import spring.hrms.entity.status.CandidateStatus;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link spring.hrms.entity.employee.Candidate}
 */
@Value
@Builder
public class CandidateResponse implements Serializable {
    Integer id;
    String name;
    String appliedFor;
    LocalDate appliedDate;
    String email;
    String phone;
    CandidateStatus status;
}