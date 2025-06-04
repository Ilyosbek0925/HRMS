package spring.hrms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.hrms.entity.employee.EmployeePersonal;
import spring.hrms.entity.status.ProjectStatus;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Project extends BaseEntity {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private ProjectStatus status;
    @ManyToOne
    @JoinColumn(name = "employee_Id")
    private EmployeePersonal employeePersonal;


}
