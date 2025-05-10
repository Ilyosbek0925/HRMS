package spring.hrms.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.hrms.DTO.request.HolidayRequest;
import spring.hrms.DTO.response.HolidayResponse;
import spring.hrms.entity.Holiday;
import spring.hrms.mapper.HolidayMapper;
import spring.hrms.repository.HolidayRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HolidayService {
    private final HolidayRepository holidayRepository;
    private final HolidayMapper holidayMapper;

    public HolidayResponse addHoliday(HolidayRequest holidayRequest) {
        Holiday holiday = holidayMapper.toHoliday(holidayRequest);
        Holiday save = holidayRepository.save(holiday);
        return holidayMapper.toHolidayResponse(save);
    }


    public List<HolidayResponse> getAllHoliday() {
        List<Holiday> all = holidayRepository.findAll();
        return holidayMapper.toHolidayResponses(all);
    }

    public void deleteHoliday(LocalDate holidayDate) {




    }
}
