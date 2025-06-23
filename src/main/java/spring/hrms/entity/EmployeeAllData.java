package spring.hrms.entity;

import lombok.Builder;
import lombok.Data;
import spring.hrms.entity.employee.AccountAccess;
import spring.hrms.entity.employee.EmployeePersonal;
import spring.hrms.entity.employee.EmployeeProfessional;
import spring.hrms.entity.employee.document.*;

import java.util.ArrayList;
@Builder
@Data
public class EmployeeAllData {
    Integer storageId;
    EmployeePersonal employeePersonal;
    EmployeeProfessional employeeProfessional;
    EmployeePhoto photo;
    AccountAccess accountAccess;

    @Builder.Default
    ArrayList<Document> documents = new ArrayList<>();
}
