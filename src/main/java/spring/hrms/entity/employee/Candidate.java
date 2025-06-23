package spring.hrms.entity.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import spring.hrms.entity.BaseEntity;
import spring.hrms.entity.status.CandidateStatus;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Candidate extends BaseEntity {
    private String name;
    private String appliedFor;
    private LocalDate appliedDate;
    private String email;
    private String phone;
    @Enumerated(EnumType.STRING)
    private CandidateStatus status;

}
