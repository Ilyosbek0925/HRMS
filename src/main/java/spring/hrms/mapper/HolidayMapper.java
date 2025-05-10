package spring.hrms.mapper;

import org.springframework.stereotype.Component;
import spring.hrms.DTO.request.HolidayRequest;
import spring.hrms.DTO.response.HolidayResponse;
import spring.hrms.entity.Holiday;

import java.util.ArrayList;
import java.util.List;

@Component
public class HolidayMapper {
    public Holiday toHoliday(HolidayRequest holidayRequest) {
        Holiday holiday = new Holiday();
        holiday.setHolidayDate(holidayRequest.getHolidayDate());
        holiday.setHolidayName(holidayRequest.getHolidayName());
        return holiday;
    }

    public HolidayResponse toHolidayResponse(Holiday holiday) {
        return HolidayResponse.builder()
                .holidayDate(holiday.getHolidayDate())
                .holidayName(holiday.getHolidayName())
                .build();
    }

    public List<Holiday> toHolidays(List<HolidayRequest> holidayRequests) {
        List<Holiday> holidays = new ArrayList<Holiday>();
        List<Holiday> list = holidayRequests.stream().map(this::toHoliday).toList();
        return list;
    }

    public List<HolidayResponse> toHolidayResponses(List<Holiday> holidayResponses) {
        List<HolidayResponse> list = holidayResponses.stream().map(this::toHolidayResponse).toList();
        return list;
    }





}
