package spring.hrms.DTO.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.DayOfWeek;
import java.util.Set;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountAccessResponse {
    private Integer storageId;
    private String employeeId;
    private String userName;
    private String employeeType;
    private String emailAddress;
    private String department;
    private String designation;
    private Set<DayOfWeek> workingDays;
    private String location;
}
