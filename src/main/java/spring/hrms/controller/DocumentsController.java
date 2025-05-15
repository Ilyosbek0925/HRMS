package spring.hrms.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import spring.hrms.service.employeeService.DocumentService;

import javax.swing.*;

@RestController
@RequestMapping("documents")
@RequiredArgsConstructor
public class DocumentsController {
    private final DocumentService documentService;

@PostMapping("uploadAppointmentLetter")
    public ResponseEntity appointmentLetterUpload(@RequestParam MultipartFile file) {
documentService.uploadApplicationLetter(file);

    }

@PostMapping("uploadSalarySlip")
    public ResponseEntity salarySlipUpload(@RequestParam MultipartFile file){

    }

@PostMapping("uploadRelivingLetter")
    public ResponseEntity relivingLetterUpload(@RequestParam MultipartFile file){

    }

@PostMapping("uploadExperienceLetter")
    public ResponseEntity experienceLetterUpload(@RequestParam MultipartFile file){

    }



}
