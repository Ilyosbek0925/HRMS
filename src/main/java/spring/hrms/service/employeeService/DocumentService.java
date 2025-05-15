package spring.hrms.service.employeeService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import spring.hrms.aws.DownloadUploadService;
import spring.hrms.entity.employee.EmployeeDocuments;

@Service
@RequiredArgsConstructor
public class DocumentService {
private final DownloadUploadService service;

    public void uploadApplicationLetter(MultipartFile file) {
service.uploadFile(file);
        EmployeeDocuments employeeDocuments = new EmployeeDocuments();
        employeeDocuments.


    }
}
