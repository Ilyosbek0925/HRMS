package spring.hrms.mapper;

import org.springframework.stereotype.Component;
import spring.hrms.DTO.request.HolidayRequest;
import spring.hrms.DTO.response.HolidayResponse;
import spring.hrms.entity.Holiday;

import java.time.DayOfWeek;
import java.util.List;

@Component
public class HolidayMapper {
    public Holiday toHoliday(HolidayRequest holidayRequest) {
        Holiday holiday = new Holiday();
        holiday.setHolidayDate(holidayRequest.getHolidayDate());
        holiday.setHolidayName(holidayRequest.getHolidayName());
        holiday.setDayOfWeek(holidayRequest.getHolidayDate().getDayOfWeek().toString());
        return holiday;
    }

    public HolidayResponse toHolidayResponse(Holiday holiday) {
        return HolidayResponse.builder()
                .holidayId(holiday.getId())
                .holidayDate(holiday.getHolidayDate())
                .holidayName(holiday.getHolidayName())
                .holidayDayOfWeek(DayOfWeek.valueOf(holiday.getDayOfWeek()))
                .build();
    }


    public List<HolidayResponse> toHolidayResponses(List<Holiday> holidayResponses) {
        return holidayResponses.stream().map(this::toHolidayResponse).toList();
    }





}
