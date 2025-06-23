package spring.hrms.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.hrms.DTO.request.PayRollDto;
import spring.hrms.DTO.response.DocumentResponse;
import spring.hrms.DTO.response.PayRollResponse;
import spring.hrms.service.PayrollService;

import java.util.List;

@RestController()
@RequestMapping("payroll")
@RequiredArgsConstructor
public class PayrollController {
    private final PayrollService service;

    @GetMapping("exportPayRoll")
    public ResponseEntity<byte[]> getPayrollData() {
        DocumentResponse response = service.exportPayRoll();
        return ResponseEntity.status(200)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + response.getOriginalName() + "\"")
                .contentType(MediaType.valueOf(response.getFileType()))
                .body(response.getFile());
    }

    @PostMapping
    public ResponseEntity<PayRollResponse> addPayRoll(@RequestBody PayRollDto payrollDto) {
        PayRollResponse payRollResponse = service.addPayRoll(payrollDto);
        System.out.println(payrollDto.getStatus().toString());
        return ResponseEntity.ok().body(payRollResponse);
    }

    @GetMapping
    public ResponseEntity<Page<PayRollResponse>> getPayRoll(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size
    ) {
        Pageable payRollPage = PageRequest.of(page, size);
        Page<PayRollResponse> payRollDtoPage = service.getPayRoll(payRollPage);
        return ResponseEntity.ok().body(payRollDtoPage);
    }

    @PutMapping("/{payrollId}")
    public ResponseEntity<PayRollResponse> updatePayRoll(@PathVariable int payrollId, @RequestBody PayRollDto payRollDto) {
        PayRollResponse response = service.updatePayRoll(payrollId, payRollDto);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{payrollId}")
    public ResponseEntity<String> deletePayRoll(@PathVariable Integer payrollId) {
        service.deletePayRoll(payrollId);
        return ResponseEntity.ok().body("Payroll deleted");
    }

    @GetMapping("/filter")
    public ResponseEntity<List<PayRollResponse>> filter(@RequestParam(required = false)String name,
                                                        @RequestParam(required = false)Double monthSalary,
                                                        @RequestParam(required = false)String status) {

        List<PayRollResponse>all=service.filter(name,monthSalary,status);
        return  ResponseEntity.ok().body(all);
    }

}
