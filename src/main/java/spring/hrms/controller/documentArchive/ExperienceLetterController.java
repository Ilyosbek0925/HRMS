/*
package spring.hrms.controller.document;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spring.hrms.DTO.response.DocumentResponse;
import spring.hrms.service.employeeService.document.ExperienceLetterService;


@RestController
@RequestMapping("document")
@RequiredArgsConstructor
public class ExperienceLetterController {
    private final ExperienceLetterService service;


    @PostMapping("uploadExperienceLetter/{employeeId}")
    public ResponseEntity uploadAppointmentLetter(@RequestParam MultipartFile file,@PathVariable Integer employeeId) {
        service.uploadExperienceLetter(file,employeeId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("downloadExperienceLetterById/{id}")
    public ResponseEntity getAppointmentLetter(@PathVariable Integer id) {
        DocumentResponse response =service.downloadAppointmentLetter(id);
        return ResponseEntity.status(200)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + response.getOriginalName() + "\"")
                .contentType(MediaType.valueOf(response.getFileType()))
                .body(response.getFile());
    }

}

*/
