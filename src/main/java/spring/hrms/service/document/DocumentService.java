package spring.hrms.service.document;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import spring.hrms.DTO.response.DocumentResponse;
import spring.hrms.aws.DownloadUploadService;
import spring.hrms.entity.EmployeeAllData;
import spring.hrms.entity.employee.EmployeePersonal;
import spring.hrms.entity.employee.document.*;
import spring.hrms.mapper.DocumentMapper;
import spring.hrms.repository.employeeRepo.EmployeePersonalRepo;
import spring.hrms.repository.employeeRepo.document.*;
import spring.hrms.temporaryStorage.TemporaryStorage;

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
    private final List<EmployeeAllData> temporaryStorage = TemporaryStorage.allEmployees;
    public List<DocumentResponse> getDocuments(int employeeId) {
        EmployeePersonal employee = employeeRepo.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found"));
        List<Document> documents = employee.getDocuments();
        System.out.println(documents.size());
        List<DocumentResponse> responses = new ArrayList<>();
        for (Document document : documents) {
            responses.add(DocumentResponse.builder()
                    .originalName(document.getOriginalName())
                    .documentId(document.getId())
                    .downloadUrl(document.getDownloadUrl())
                    .build());
        }
        return responses;
    }


    public DocumentResponse uploadFile(MultipartFile file, int storageId) {
        EmployeePersonal employee = temporaryStorage.get(storageId).getEmployeePersonal();
        DocumentResponse response = downloadService.uploadFile(file);
        Document document = new Document();
        document.setServerName(response.getServerName());
        document.setFileType(response.getFileType());
        document.setOriginalName(file.getOriginalFilename());
        document.setEmployeePersonal(employee);
        document.setDownloadUrl(domainName + "/employee-document/" + response.getServerName());
        temporaryStorage.get(storageId).getDocuments().add(document);
        return mapper.toDocumentResponse(document);
    }


    public DocumentResponse update(int documentId, MultipartFile file) {
        Document document = documentRepo.findById(documentId).orElseThrow(() -> new RuntimeException("Document not found"));
        document.setOriginalName(file.getOriginalFilename());
        DocumentResponse response = downloadService.uploadFile(file);
        document.setServerName(response.getServerName());
        document.setId(documentId);
        document.setFileType(response.getFileType());
        document.setDownloadUrl(domainName + "/employee-document/" + response.getServerName());
        return mapper.toDocumentResponse(documentRepo.save(document));
    }


    public void delete(int documentId) {
        if (documentRepo.existsById(documentId)) {
            documentRepo.deleteById(documentId);
        } else throw new EntityNotFoundException("Document not found");
    }

    public DocumentResponse downloadDocument(String serverName) {
            Document document = documentRepo.findByServerName(serverName).orElseThrow(() -> new EntityNotFoundException("entity not found" + serverName));
            byte[] file = downloadService.downloadFile(serverName);
            return DocumentResponse.builder()
                    .file(file)
                    .fileType(document.getFileType())
                    .originalName(document.getOriginalName())
                    .build();
    }
}
