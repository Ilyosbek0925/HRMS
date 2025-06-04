package spring.hrms.entity.employee.document;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import spring.hrms.entity.BaseEntity;
import spring.hrms.entity.employee.EmployeePersonal;

@Entity
@Getter
@Setter
public class Document extends BaseEntity {
    private String originalName;
    private String serverName;
    private String fileType;
    private String downloadUrl;
    private double size;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @JsonManagedReference
    EmployeePersonal employeePersonal;

}
