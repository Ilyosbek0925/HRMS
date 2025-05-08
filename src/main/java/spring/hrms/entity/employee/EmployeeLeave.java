package spring.hrms.entity.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.hrms.entity.BaseEntity;
import spring.hrms.entity.status.SalaryStatus;

import java.time.Duration;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeLeave extends BaseEntity {
    private LocalDate date;
    private Duration duration;
    private SalaryStatus salaryStatus;
    @OneToOne
    private EmployeePersonal employeePersonal;
}
