/*
package spring.hrms.service.employeeService.document;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import spring.hrms.DTO.response.DocumentResponse;
import spring.hrms.aws.DownloadUploadService;
import spring.hrms.entity.EmployeeAllData;
import spring.hrms.entity.employee.EmployeePersonal;
import spring.hrms.entity.employee.archiveDocument.SalarySlip;
import spring.hrms.repository.employeeRepo.EmployeePersonalRepo;
import spring.hrms.repository.employeeRepo.archiveDocument.SalarySlipRepo;
import spring.hrms.temporaryStorage.TemporaryStorage;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SalarySlipService {
    private final DownloadUploadService downloadUploadService;
    private final SalarySlipRepo repository;
    private final EmployeePersonalRepo employeePersonalRepo;
    private List<EmployeeAllData> temporaryStorage = TemporaryStorage.allEmployees;

    public void uploadSalarySlipLetter(MultipartFile file, Integer storageId) {
        EmployeePersonal employee = temporaryStorage.get(storageId).getEmployeePersonal();
        String serverName = downloadUploadService.uploadFile(file);
        SalarySlip letter = new SalarySlip();
        letter.setOriginalName(file.getOriginalFilename());
        letter.setServerName(serverName);
        letter.setEmployeePersonal(employee);
temporaryStorage.get(storageId).setSalarySlip(letter);
    }

    public DocumentResponse downloadSalarySlipLetter(Integer employeeId) {
        Optional<EmployeePersonal> byId = employeePersonalRepo.findById(employeeId);
        EmployeePersonal user = byId.orElseThrow(() -> new RuntimeException("userNot Found"));
        byte[] file = downloadUploadService.downloadFile(user.getSalarySlip().getServerName());
        return DocumentResponse.builder()
                .file(file)
                .fileType(user.getAppointmentLetter().getFileType())
                .originalName(user.getAppointmentLetter().getOriginalName())
                .build();
    }
}
*/
