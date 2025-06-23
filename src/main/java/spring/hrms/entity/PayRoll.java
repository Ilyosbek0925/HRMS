package spring.hrms.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import spring.hrms.entity.employee.EmployeePersonal;
import spring.hrms.entity.status.PayRollStatus;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class PayRoll extends BaseEntity{
    private String employeeName;
    private BigDecimal ctc;
    private BigDecimal salaryPerMonth;
    private BigDecimal deduction;
    @Enumerated(EnumType.STRING)
    private PayRollStatus status;

    @OneToOne(fetch = FetchType.EAGER)
    private EmployeePersonal employeePersonal;
}
