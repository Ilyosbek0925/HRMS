package spring.hrms.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.hrms.DTO.request.PayRollDto;
import spring.hrms.DTO.response.DocumentResponse;
import spring.hrms.DTO.response.PayRollResponse;
import spring.hrms.service.PayrollService;

@RestController()
@RequestMapping("payroll")
@RequiredArgsConstructor
public class PayrollController {
    private final PayrollService service;

    @GetMapping("exportPayRoll")
    public ResponseEntity<byte[]> getPayrollData() {
DocumentResponse response=service.exportPayRoll();
      return   ResponseEntity.status(200)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + response.getOriginalName() + "\"")
                .contentType(MediaType.valueOf(response.getFileType()))
                .body(response.getFile());
    }

    @PostMapping("addPayRoll")
    public ResponseEntity<PayRollResponse> addPayRoll(@RequestBody PayRollDto payrollDto) {
        PayRollResponse payRollResponse = service.addPayRoll(payrollDto);
        System.out.println(payrollDto.getStatus().toString());
        return ResponseEntity.ok().body(payRollResponse);
    }

        @GetMapping("getPayRoll")
        public ResponseEntity<Page<PayRollResponse>> getPayRoll(
                @RequestParam(defaultValue = "0") int page,
                @RequestParam(defaultValue = "10") int size,
                @RequestParam(defaultValue = "id") String sortBy
        ) {
            Pageable payRollPage = PageRequest.of(page, size, Sort.by(sortBy));
            Page<PayRollResponse> payRollDtoPage = service.getPayRoll(payRollPage);
            return ResponseEntity.ok().body(payRollDtoPage);
        }

    @PutMapping("updatePayroll/{payrollId}")
    public ResponseEntity<PayRollResponse> updatePayRoll(@PathVariable int payrollId, @RequestBody PayRollDto payRollDto) {
        PayRollResponse response = service.updatePayRoll(payrollId, payRollDto);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("deletePayRoll/{payrollId}")
    public ResponseEntity<String> deletePayRoll(@PathVariable Integer payrollId) {
        service.deletePayRoll(payrollId);
        return ResponseEntity.ok().body("Payroll deleted");
    }

}
