package spring.hrms.entity;

import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;
import spring.hrms.DTO.request.AccountAccessRequest;
import spring.hrms.DTO.request.EmployeePersonalRequest;
import spring.hrms.DTO.request.EmployeeProfessionalRequest;
import spring.hrms.entity.employee.AccountAccess;
import spring.hrms.entity.employee.EmployeeDocuments;
import spring.hrms.entity.employee.EmployeePersonal;
import spring.hrms.entity.employee.EmployeeProfessional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Set;
@Builder
@Data
public class EmployeeAllData {
    Integer storageId;
    EmployeePersonal employeePersonal;
    EmployeeProfessional employeeProfessional;
    EmployeeDocuments employeeDocuments;
    AccountAccess accountAccess;
}
