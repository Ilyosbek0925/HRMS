/*
package spring.hrms.service.employeeService.document;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import spring.hrms.DTO.response.DocumentResponse;
import spring.hrms.aws.DownloadUploadService;
import spring.hrms.entity.EmployeeAllData;
import spring.hrms.entity.employee.EmployeePersonal;
import spring.hrms.entity.employee.archiveDocument.ExperienceLetter;
import spring.hrms.repository.employeeRepo.EmployeePersonalRepo;
import spring.hrms.repository.employeeRepo.archiveDocument.ExperienceLetterRepo;
import spring.hrms.temporaryStorage.TemporaryStorage;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExperienceLetterService {
    private final DownloadUploadService downloadUploadService;
    private final ExperienceLetterRepo repository;
    private final EmployeePersonalRepo employeePersonalRepo;
    private List<EmployeeAllData> temporaryStorage = TemporaryStorage.allEmployees;

    public void uploadExperienceLetter(MultipartFile file, Integer employeeId) {
        EmployeePersonal employee = temporaryStorage.get(employeeId).getEmployeePersonal();
        String serverName = downloadUploadService.uploadFile(file);
        ExperienceLetter experience = new ExperienceLetter();
        experience.setOriginalName(file.getOriginalFilename());
        experience.setServerName(serverName);
        experience.setEmployeePersonal(employee);
        temporaryStorage.get(employeeId).setExperienceLetter(experience);
    }

    public DocumentResponse downloadAppointmentLetter(Integer employeeId) {
        Optional<EmployeePersonal> byId = employeePersonalRepo.findById(employeeId);
        EmployeePersonal user = byId.orElseThrow(() -> new RuntimeException("userNot Found"));
        byte[] file = downloadUploadService.downloadFile(user.getExperienceLetter().getServerName());
        return DocumentResponse.builder()
                .file(file)
                .fileType(user.getAppointmentLetter().getFileType())
                .originalName(user.getAppointmentLetter().getOriginalName())
                .build();
    }

}
*/
