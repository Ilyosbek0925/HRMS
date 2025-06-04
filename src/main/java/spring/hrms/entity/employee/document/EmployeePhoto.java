package spring.hrms.entity.employee.document;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import spring.hrms.entity.BaseEntity;
import spring.hrms.entity.employee.EmployeePersonal;

@Entity
@Getter
@Setter
public class EmployeePhoto extends BaseEntity {
    private String originalName;
    private String serverName;
    private String fileType;
    private String downloadUrl;
    private double size;
    @OneToOne
    @JsonManagedReference
    EmployeePersonal employeePersonal;
}
