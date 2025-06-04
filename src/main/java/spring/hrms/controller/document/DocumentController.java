package spring.hrms.controller.document;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spring.hrms.DTO.ApiResponseDto;
import spring.hrms.DTO.response.DocumentResponse;
import spring.hrms.entity.status.ResponseStatus;
import spring.hrms.service.employeeService.document.DocumentService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("employee-document")
@RequiredArgsConstructor
public class DocumentController {
    private final DocumentService service;

    @GetMapping("/{employeeId}")
    public ResponseEntity<List<DocumentResponse>> getEmployeeDocument(@PathVariable int employeeId) {
        List<DocumentResponse> response = service.getDocuments(employeeId);
        return ResponseEntity.ok(response);
    }


    @PostMapping("{employeeId}")
    public ResponseEntity<DocumentResponse> addDocument(@PathVariable int employeeId, @RequestParam MultipartFile file) {
        DocumentResponse response = service.uploadFile(file, employeeId);
        return ResponseEntity.ok(response);
    }


    @PutMapping("/{documentId}")
    public ResponseEntity<DocumentResponse> updateDocument(@PathVariable int documentId, @RequestParam MultipartFile file) {
        DocumentResponse response = service.update(documentId, file);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{documentId}")
    public ResponseEntity<ApiResponseDto> deleteDocument(@PathVariable int documentId) {
        service.delete(documentId);
        return ResponseEntity.ok(new ApiResponseDto(ResponseStatus.SUCCESS, "deleted successfully", LocalDateTime.now()));
    }


}