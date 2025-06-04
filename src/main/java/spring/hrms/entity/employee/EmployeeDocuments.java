package spring.hrms.entity.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import spring.hrms.entity.BaseEntity;

@Entity
@Getter
@Setter
public class EmployeeDocuments extends BaseEntity {

private String appointmentLetter;
private String appointmentLetterServerName;
private String salarySlips;
private String salarySlipsServerName;
private String revilingLetter;
private String revilingLetterServerName;
private String experienceLetter;
private String experienceLetterServerName;

@OneToOne
private EmployeeProfessional employeeProfessional;
}
