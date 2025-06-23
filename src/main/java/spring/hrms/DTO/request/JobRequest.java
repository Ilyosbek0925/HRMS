package spring.hrms.DTO.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobRequest {
    private String department;
    private String title;
    private String location;
    private String workType;
    private String amount;

}
