package spring.hrms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import spring.hrms.entity.employee.EmployeePersonal;
import spring.hrms.entity.status.PayRollStatus;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class PayRoll extends BaseEntity{
    private BigDecimal ctc;
    private BigDecimal salaryPerMonth;
    private BigDecimal deduction;
    @Enumerated(EnumType.STRING)
    private PayRollStatus status;

    @OneToOne
    private EmployeePersonal employeePersonal;
}
