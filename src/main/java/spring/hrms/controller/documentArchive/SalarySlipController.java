/*
package spring.hrms.controller.document;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spring.hrms.DTO.response.DocumentResponse;
import spring.hrms.service.employeeService.document.SalarySlipService;

@RestController
@RequestMapping("document")
@RequiredArgsConstructor
public class SalarySlipController {
    private final SalarySlipService service;
    @PostMapping("uploadSalarySlipLetter/{employeeId}")
    public ResponseEntity uploadRelivingLetter(@RequestParam MultipartFile file, @PathVariable Integer employeeId) {
        service.uploadSalarySlipLetter(file, employeeId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("downloadSalarySlipById/{id}")
    public ResponseEntity getRelivingLetter(@PathVariable Integer id) {
        DocumentResponse response = service.downloadSalarySlipLetter(id);
        return ResponseEntity.status(200)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + response.getOriginalName() + "\"")
                .contentType(MediaType.valueOf(response.getFileType()))
                .body(response.getFile());
    }

}
*/
