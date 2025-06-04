package spring.hrms.DTO.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;



@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeePersonalResponse {
private Integer storageId;
private Integer employeeId;
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
}
