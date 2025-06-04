package spring.hrms.entity.employee;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.hrms.entity.BaseEntity;
import spring.hrms.entity.status.AttendanceStatus;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Attendance extends BaseEntity {
private LocalDate date;
private LocalTime checkIn;
private LocalTime checkTime;
private LocalTime checkOut;
private LocalTime breakTime;
private LocalTime workingHours;
@Enumerated(EnumType.STRING)
private AttendanceStatus status;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeePersonal employeePersonal;
}


