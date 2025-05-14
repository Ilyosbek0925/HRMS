package spring.hrms.DTO.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class JobResponse {
    private Integer id;
    private String department;
    private String title;
    private String location;
    private String workType;
    private String amount;
}
