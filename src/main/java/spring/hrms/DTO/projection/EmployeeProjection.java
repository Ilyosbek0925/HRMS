package spring.hrms.DTO.projection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeProjection {
    private String downloadUrl;
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private String department;
    private String designation;
    private String employeeType;
}
