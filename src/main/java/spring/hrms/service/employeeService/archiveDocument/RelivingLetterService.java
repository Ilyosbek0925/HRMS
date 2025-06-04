/*
package spring.hrms.service.employeeService.document;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import spring.hrms.DTO.response.DocumentResponse;
import spring.hrms.aws.DownloadUploadService;
import spring.hrms.entity.EmployeeAllData;
import spring.hrms.entity.employee.EmployeePersonal;
import spring.hrms.entity.employee.archiveDocument.RelivingLetter;
import spring.hrms.repository.employeeRepo.EmployeePersonalRepo;
import spring.hrms.repository.employeeRepo.archiveDocument.RelivingLetterRepo;
import spring.hrms.temporaryStorage.TemporaryStorage;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RelivingLetterService {
    private final DownloadUploadService downloadUploadService;
    private final RelivingLetterRepo repository;
    private final EmployeePersonalRepo employeePersonalRepo;
    private List<EmployeeAllData> temporaryStorage = TemporaryStorage.allEmployees;

    public void uploadExperienceLetter(MultipartFile file, Integer storageId) {
        EmployeePersonal employee = temporaryStorage.get(storageId).getEmployeePersonal();
        String serverName = downloadUploadService.uploadFile(file);
       RelivingLetter letter = new RelivingLetter();
        letter.setOriginalName(file.getOriginalFilename());
        letter.setServerName(serverName);
        letter.setEmployeePersonal(employee);
      temporaryStorage.get(storageId).setRelivingLetter(letter);
    }

    public DocumentResponse downloadRelivingLetter(Integer employeeId) {
        Optional<EmployeePersonal> byId = employeePersonalRepo.findById(employeeId);
        EmployeePersonal user = byId.orElseThrow(() -> new RuntimeException("userNot Found"));
        byte[] file = downloadUploadService.downloadFile(user.getRelivingLetter().getServerName());
        return DocumentResponse.builder()
                .file(file)
                .fileType(user.getAppointmentLetter().getFileType())
                .originalName(user.getAppointmentLetter().getOriginalName())
                .build();
    }





}
*/
