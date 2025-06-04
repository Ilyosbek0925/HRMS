package spring.hrms.entity;

import lombok.Builder;
import lombok.Data;
import spring.hrms.entity.employee.AccountAccess;
import spring.hrms.entity.employee.EmployeePersonal;
import spring.hrms.entity.employee.EmployeeProfessional;
//import spring.hrms.entity.employee.archiveDocument.AppointmentLetter;
//import spring.hrms.entity.employee.archiveDocument.ExperienceLetter;
//import spring.hrms.entity.employee.archiveDocument.RelivingLetter;
//import spring.hrms.entity.employee.archiveDocument.SalarySlip;
import spring.hrms.entity.employee.document.*;

@Builder
@Data
public class EmployeeAllData {
    Integer storageId;
    EmployeePersonal employeePersonal;
    EmployeeProfessional employeeProfessional;
//   AppointmentLetter appointmentLetter;
//   ExperienceLetter experienceLetter;
//   RelivingLetter relivingLetter;
//   SalarySlip salarySlip;
   EmployeePhoto photo;
    AccountAccess accountAccess;
}
