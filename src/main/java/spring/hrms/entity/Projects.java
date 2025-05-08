package spring.hrms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
public class Projects extends BaseEntity {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private ProjectStatus status;
    @ManyToMany
    @JoinTable(name = "project_employee",
    joinColumns = @JoinColumn(name = "project_id")
    ,inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private List<EmployeePersonal> employeePersonal;












}
