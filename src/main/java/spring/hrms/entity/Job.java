package spring.hrms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.hrms.entity.status.JobStatus;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Job extends BaseEntity{
    private String department;
    private String jobTitle;
    private String location;
    private String amount;
    private String workType;
    @Enumerated(EnumType.STRING)
    private JobStatus status;

}
