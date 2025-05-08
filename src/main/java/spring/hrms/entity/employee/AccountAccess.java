package spring.hrms.entity.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.hrms.entity.BaseEntity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountAccess extends BaseEntity {
    private String emailAddress;
    private String skypeId;
    private String slackId;
    private String gitHubId;
    @OneToOne
    private EmployeePersonal employeePersonal;
}
