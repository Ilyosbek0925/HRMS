package spring.hrms.DTO.projection;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.hrms.entity.status.AttendanceStatus;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceProjection {
   private Integer attendanceId;
    private String downloadUrl;
    private String firstName;
    private String lastName;
    private String designation;
    private String type;
    private LocalTime breakTime;
    private LocalTime checkOut;
    private LocalTime checkTime;
    private LocalDate date;
    private AttendanceStatus status;
    private LocalTime checkIn;
    private LocalTime workingHours;


}
