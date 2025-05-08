package spring.hrms.entity.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.hrms.entity.BaseEntity;
import spring.hrms.entity.status.SalaryStatus;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PayRoll extends BaseEntity {
    private String CTC;
    private String salaryPerMonth;
    private String deduction;
    private SalaryStatus salaryStatus;

    @OneToOne
    private EmployeePersonal employeePersonal;


}
