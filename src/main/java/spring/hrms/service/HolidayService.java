package spring.hrms.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import spring.hrms.DTO.request.HolidayRequest;
import spring.hrms.DTO.response.HolidayResponse;
import spring.hrms.entity.Holiday;
import spring.hrms.exception.HolidayNotFoundException;
import spring.hrms.mapper.HolidayMapper;
import spring.hrms.repository.HolidayRepository;
import spring.hrms.spesification.HolidaySpecification;

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

    public void deleteHoliday(Integer holidayId) {
        if (holidayRepository.existsById(holidayId)) {
            holidayRepository.deleteById(holidayId);
        }else throw new HolidayNotFoundException("Holiday not found with id "+holidayId);
    }

    public List<HolidayResponse> filter(String date, String dayOfWeek, String holidayName) {
        Specification<Holiday> specification = Specification.where(HolidaySpecification.hasDate(date)).and(HolidaySpecification.hasDay(dayOfWeek)).and(HolidaySpecification.hasHolidayName(holidayName));
        List<Holiday> all = holidayRepository.findAll(specification);
        return holidayMapper.toHolidayResponses(all);
    }
}
