package spring.hrms.service.employeeService.document;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import spring.hrms.DTO.response.DocumentResponse;
import spring.hrms.aws.DownloadUploadService;
import spring.hrms.entity.employee.EmployeePersonal;
import spring.hrms.entity.employee.document.*;
import spring.hrms.mapper.DocumentMapper;
import spring.hrms.repository.employeeRepo.EmployeePersonalRepo;
import spring.hrms.repository.employeeRepo.document.*;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentService {
    private final EmployeePersonalRepo employeeRepo;
    private final DownloadUploadService downloadService;
    private final DocumentRepo documentRepo;
    private final DocumentMapper mapper;
    @Value("${project.domainName}")
    private String domainName;

    public List<DocumentResponse> getDocuments(int employeeId) {
        EmployeePersonal employee = employeeRepo.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found"));
//        SalarySlip salarySlip = employee.getSalarySlip();
//        AppointmentLetter appointmentLetter = employee.getAppointmentLetter();
//        ExperienceLetter experienceLetter = employee.getExperienceLetter();
//        RelivingLetter relivingLetter = employee.getRelivingLetter();
        List<Document> documents = employee.getDocuments();
        List<DocumentResponse> responses = new ArrayList<>();
//        responses.add(DocumentResponse.builder()
//                        .originalName(salarySlip.getOriginalName())
//                        .documentId(salarySlip.getId())
//                .build());
//        responses.add(DocumentResponse.builder()
//                        .originalName(appointmentLetter.getOriginalName())
//                        .documentId(appointmentLetter.getId())
//                .build());
//        responses.add(DocumentResponse.builder()
//                        .originalName(experienceLetter.getOriginalName())
//                        .documentId(experienceLetter.getId())
//                .build());
//        responses.add(DocumentResponse.builder()
//                        .originalName(relivingLetter.getOriginalName())
//                        .documentId(relivingLetter.getId())
//                .build());
        for (Document document : documents) {
            responses.add(DocumentResponse.builder()
                    .originalName(document.getOriginalName())
                    .documentId(document.getId())
                    .build());
        }
        return responses;
    }


    public DocumentResponse uploadFile(MultipartFile file, int employeeId) {
        DocumentResponse response = downloadService.uploadFile(file);
        EmployeePersonal employee = employeeRepo.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found"));
        Document document = new Document();
        document.setServerName(response.getServerName());
        document.setFileType(response.getFileType());
        document.setOriginalName(file.getOriginalFilename());
        document.setEmployeePersonal(employee);
        Document save = documentRepo.save(document);
        return mapper.toDocumentResponse(save);
    }


    public DocumentResponse update(int documentId, MultipartFile file) {
        Document document = documentRepo.findById(documentId).orElseThrow(() -> new RuntimeException("Document not found"));
        document.setOriginalName(file.getOriginalFilename());
        DocumentResponse response = downloadService.uploadFile(file);
        document.setServerName(response.getServerName());
        document.setId(documentId);
        document.setFileType(response.getFileType());
        document.setDownloadUrl(domainName+"employee-documents/"+response.getServerName());
        return mapper.toDocumentResponse(documentRepo.save(document));
    }


    public void delete(int documentId) {
        if (documentRepo.existsById(documentId)) {
            documentRepo.deleteById(documentId);
        } else throw new EntityNotFoundException("Document not found");
    }
}
