package spring.hrms.controller.document;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spring.hrms.DTO.ApiResponseDto;
import spring.hrms.DTO.response.DocumentResponse;
import spring.hrms.entity.status.ResponseStatus;
import spring.hrms.service.document.EmployeePhotoService;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("employee-photo")

public class EmployeePhotoController {
    private final EmployeePhotoService service;
    @PostMapping("/{storageId}")
    public ResponseEntity<ApiResponseDto> uploadRelivingLetter(@RequestParam MultipartFile file, @PathVariable Integer storageId) {
        service.uploadEmployeePhoto(file, storageId);
        return ResponseEntity.ok(new ApiResponseDto(ResponseStatus.SUCCESS,"photo added successfully", LocalDateTime.now()));
    }

    @GetMapping("/{serverName}")
    public ResponseEntity<byte[]> getRelivingLetter(@PathVariable String serverName) {
        DocumentResponse response = service.downloadEmployeePhoto(serverName);
        return ResponseEntity.status(200)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + response.getOriginalName() + "\"")
                .contentType(MediaType.valueOf(response.getFileType()))
                .body(response.getFile());
    }


    @GetMapping("by-employeeId/{employeeId}")
    public ResponseEntity<DocumentResponse> getEmployeePhoto(@PathVariable Integer employeeId) {

        DocumentResponse response=service.getPhotoLink(employeeId);
    return  ResponseEntity.ok().body(response);
    }
    @PutMapping("/{employeeId}")
    public ResponseEntity<DocumentResponse> updateDocument(@PathVariable Integer employeeId, @RequestParam("file") MultipartFile file) {
        DocumentResponse response = service.updateEmployeePhoto(file, employeeId);
        return ResponseEntity.ok().body(response);
    }

}
