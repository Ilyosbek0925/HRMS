package spring.hrms.entity.employee;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.poi.ss.formula.functions.Days360;
import org.joda.time.Days;
import spring.hrms.entity.BaseEntity;
import spring.hrms.entity.status.LeaveStatus;
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
    private int days;
    private String reportingManager;
    private LeaveStatus leaveStatus;
    private SalaryStatus salaryStatus;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonManagedReference
    private EmployeePersonal employeePersonal;
}
