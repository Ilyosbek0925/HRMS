package spring.hrms.entity.employee;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.hrms.entity.BaseEntity;
import spring.hrms.entity.Project;
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
    @OneToOne(mappedBy = "employeePersonal",fetch = FetchType.EAGER)
    @JsonBackReference
    private EmployeeProfessional employeeProfessional;
    @OneToOne(mappedBy = "employeePersonal",fetch = FetchType.EAGER)
    @JsonBackReference
    private AccountAccess accountAccess;
    @OneToOne(mappedBy = "employeePersonal" ,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonBackReference
    private EmployeePhoto employeePhoto;
    @OneToMany(mappedBy = "employeePersonal",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Attendance> attendances;

    @OneToMany(mappedBy = "employeePersonal",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Project> projects;

    @OneToMany(mappedBy = "employeePersonal",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonBackReference
    private List<EmployeeLeave> employeeLeaves;
    @OneToMany(mappedBy = "employeePersonal", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference
    private List<Document> documents;



}
