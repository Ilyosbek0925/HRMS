package spring.hrms.entity.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.hrms.entity.BaseEntity;
import spring.hrms.entity.status.AttendanceStatus;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeAttendance extends BaseEntity {
private LocalDateTime checkTime;
private AttendanceStatus status;
    @OneToOne
    private EmployeePersonal employee;


}


