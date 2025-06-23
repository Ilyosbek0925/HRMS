package spring.hrms.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.hrms.DTO.request.HolidayRequest;
import spring.hrms.DTO.response.HolidayResponse;
import spring.hrms.service.HolidayService;

import java.util.List;

@RestController
@RequestMapping("holiday")
@RequiredArgsConstructor
public class HolidayController {
    private final HolidayService holidayService;


    @PostMapping
    public ResponseEntity<HolidayResponse> addHoliday(@RequestBody HolidayRequest holiday) {
        HolidayResponse holidayResponse = holidayService.addHoliday(holiday);
        return ResponseEntity.status(201).body(holidayResponse);
    }

    @GetMapping
    public ResponseEntity<List<HolidayResponse>> getAllHolidays() {
        List<HolidayResponse> allHoliday = holidayService.getAllHoliday();
        return ResponseEntity.status(200).body(allHoliday);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<HolidayResponse>> filter(@RequestParam(required = false) String dayOfWeek,
                                                        @RequestParam(required = false) String date,
                                                        @RequestParam(required = false) String holidayName

    ) {
        List<HolidayResponse> allHoliday = holidayService.filter(date,dayOfWeek,holidayName);
        return ResponseEntity.status(200).body(allHoliday);
    }



    @DeleteMapping("/{holidayId}")
    public ResponseEntity<HolidayResponse> deleteHolidayByDate(@PathVariable Integer holidayId) {
        holidayService.deleteHoliday(holidayId);
        return ResponseEntity.status(204).build();
    }



}
