package spring.hrms.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Jobs extends BaseEntity{
    private String department;
    private String jobTitle;
    private String location;
    private String amount;
    private String workType;

}
