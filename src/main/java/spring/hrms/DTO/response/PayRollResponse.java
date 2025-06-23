package spring.hrms.DTO.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Getter
@Setter
public class PayRollResponse {
    private Integer payRollId;
    private Integer employeeId;
    private String employeeName;
    private String ctc;
    private String salaryPerMonth;
    private String deduction;
    private String status;
}
