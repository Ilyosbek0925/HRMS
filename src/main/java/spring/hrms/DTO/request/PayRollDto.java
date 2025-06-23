package spring.hrms.DTO.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import spring.hrms.entity.status.PayRollStatus;

@Getter
@Setter
@Builder
public class PayRollDto {
    private Integer employeeId;
    private String ctc;
    private String salaryPerMonth;
    private String deduction;
    private PayRollStatus status;
}
