package spring.hrms.DTO.request;

import lombok.Getter;
import lombok.Setter;
import spring.hrms.entity.status.JobStatus;
@Getter
@Setter
public class JobUpdateRequest {
    private String department;
    private String title;
    private String location;
    private String workType;
    private String amount;
    private JobStatus jobStatus;
}
