package spring.hrms.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.hrms.DTO.request.HolidayRequest;
import spring.hrms.DTO.response.HolidayResponse;
import spring.hrms.entity.Holiday;
import spring.hrms.service.HolidayService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("holiday")
@RequiredArgsConstructor
public class HolidayController {
    private final HolidayService holidayService;


    @PostMapping("addHoliday")
    public ResponseEntity<HolidayResponse> addHoliday(HolidayRequest holiday) {
        HolidayResponse holidayResponse = holidayService.addHoliday(holiday);
        return ResponseEntity.status(201).body(holidayResponse);
    }

    @GetMapping("getAllHolidays")
    public ResponseEntity<List<HolidayResponse>> getAllHolidays() {
        List<HolidayResponse> allHoliday = holidayService.getAllHoliday();
        return ResponseEntity.status(200).body(allHoliday);
    }

    @DeleteMapping("deleteByHolidayDate")
    public ResponseEntity<HolidayResponse> deleteHolidayByDate(LocalDate holidayDate) {
        holidayService.deleteHoliday(holidayDate);
        return ResponseEntity.status(204).build();
    }



}
