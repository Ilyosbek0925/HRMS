/*
package spring.hrms.controller.document;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spring.hrms.DTO.response.DocumentResponse;
import spring.hrms.service.employeeService.document.AppointmentLetterService;

@RestController
@RequestMapping("document")
@RequiredArgsConstructor
public class AppointmentLetterController {
private final AppointmentLetterService appointmentLetterService;

    @PostMapping("uploadAppointmentLetter/{storageId}")
    public ResponseEntity uploadAppointmentLetter(@RequestParam MultipartFile file,@PathVariable Integer storageId) {
        appointmentLetterService.uploadAppointmentLetter(file,storageId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("downloadAppointmentLetterById/{id}")
    public ResponseEntity getAppointmentLetter(@PathVariable Integer id) {
       DocumentResponse response = appointmentLetterService.downloadAppointmentLetter(id);
        return ResponseEntity.status(200)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + response.getOriginalName() + "\"")
                .contentType(MediaType.valueOf(response.getFileType()))
                .body(response.getFile());
    }

}
*/
