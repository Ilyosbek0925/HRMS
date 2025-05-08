package spring.hrms.entity;

import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Holiday extends BaseEntity{
    private String holidayName;
    private LocalDate holidayDate;
}
