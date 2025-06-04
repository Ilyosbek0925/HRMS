package spring.hrms.DTO.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class PayRollResponse {
    Integer payRollId;
    private   Integer employeeId;
    private String ctc;
    private String salaryPerMonth;
    private String deduction;
    private String status;
}
