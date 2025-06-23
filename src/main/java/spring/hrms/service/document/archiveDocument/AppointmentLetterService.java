/*
package spring.hrms.service.employeeService.document;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import spring.hrms.DTO.response.DocumentResponse;
import spring.hrms.aws.DownloadUploadService;
import spring.hrms.entity.EmployeeAllData;
import spring.hrms.entity.employee.EmployeePersonal;
import spring.hrms.entity.employee.archiveDocument.AppointmentLetter;
import spring.hrms.repository.employeeRepo.EmployeePersonalRepo;
import spring.hrms.repository.employeeRepo.archiveDocument.AppointmentLetterRepo;
import spring.hrms.temporaryStorage.TemporaryStorage;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentLetterService {
    private final DownloadUploadService downloadUploadService;
    private final AppointmentLetterRepo appointmentLetterRepo;
    private List<EmployeeAllData> temporaryStorage = TemporaryStorage.allEmployees;
    private final EmployeePersonalRepo employeePersonalRepo;
    public void uploadAppointmentLetter(MultipartFile file, Integer storageId) {
        EmployeePersonal employee = temporaryStorage.get(storageId).getEmployeePersonal();
        String serverName = downloadUploadService.uploadFile(file);
        AppointmentLetter appointmentLetter = new AppointmentLetter();
        appointmentLetter.setOriginalName(file.getOriginalFilename());
        appointmentLetter.setServerName(serverName);
        appointmentLetter.setEmployeePersonal(employee);
temporaryStorage.get(storageId).setAppointmentLetter(appointmentLetter);
    }

    public DocumentResponse downloadAppointmentLetter(Integer employeeId) {
        Optional<EmployeePersonal> byId = employeePersonalRepo.findById(employeeId);
        EmployeePersonal user = byId.orElseThrow(() -> new RuntimeException("userNot Found"));
        byte[] file = downloadUploadService.downloadFile(user.getAppointmentLetter().getServerName());
      return DocumentResponse.builder()
              .file(file)
              .fileType(user.getAppointmentLetter().getFileType())
              .originalName(user.getAppointmentLetter().getOriginalName())
              .build();
    }


}
*/
