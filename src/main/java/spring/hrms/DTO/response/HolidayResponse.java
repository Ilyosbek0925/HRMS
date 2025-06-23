package spring.hrms.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HolidayResponse {
    Integer holidayId;
    private String holidayName;
    private LocalDate holidayDate;
    private DayOfWeek holidayDayOfWeek;
}
