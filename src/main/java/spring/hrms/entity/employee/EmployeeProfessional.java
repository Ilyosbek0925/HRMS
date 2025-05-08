package spring.hrms.entity.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.hrms.entity.BaseEntity;

import java.time.DayOfWeek;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeProfessional extends BaseEntity {
    private String userName;
    private String employeeType;
    private String emailAddress;
    private String department;
    private String designation;
    @Enumerated
    private Set<DayOfWeek> workingDays;
    private String location;
    @OneToOne
    private EmployeePersonal employeePersonal;






}
