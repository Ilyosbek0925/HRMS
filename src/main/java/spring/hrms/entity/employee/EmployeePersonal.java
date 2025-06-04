package spring.hrms.entity.employee;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.hrms.entity.BaseEntity;
import spring.hrms.entity.Project;
//import spring.hrms.entity.employee.archiveDocument.AppointmentLetter;
//import spring.hrms.entity.employee.archiveDocument.ExperienceLetter;
//import spring.hrms.entity.employee.archiveDocument.RelivingLetter;
//import spring.hrms.entity.employee.archiveDocument.SalarySlip;
import spring.hrms.entity.employee.document.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePersonal extends BaseEntity {
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String email;
    private LocalDate dateOfBirth;
    private String gender;
    private String nationality;
    private String address;
    private String city;
    private String state;
    private int zipCode;
//    @OneToOne(mappedBy = "employeePersonal")
//    @JsonBackReference
//    private AppointmentLetter appointmentLetter;
    @OneToOne(mappedBy = "employeePersonal")
    @JsonBackReference
    private EmployeeProfessional employeeProfessional;
    @OneToOne(mappedBy = "employeePersonal")
    @JsonBackReference
    private AccountAccess accountAccess;
//    @OneToOne(mappedBy = "employeePersonal")
//    @JsonBackReference
//    private ExperienceLetter experienceLetter;
//    @OneToOne(mappedBy = "employeePersonal")
//    @JsonBackReference
//    private SalarySlip salarySlip;
//    @OneToOne(mappedBy = "employeePersonal")
//    @JsonBackReference
//    private RelivingLetter relivingLetter;
    @OneToOne(mappedBy = "employeePersonal" ,cascade = CascadeType.ALL)
    @JsonBackReference
    private EmployeePhoto employeePhoto;
    @OneToMany(mappedBy = "employeePersonal",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Attendance> attendances;

    @OneToMany(mappedBy = "employeePersonal",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Project> projects;

    @OneToMany(mappedBy = "employeePersonal",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<EmployeeLeave> employeeLeaves;

    @OneToMany(mappedBy = "employeePersonal",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Document> documents;



}
