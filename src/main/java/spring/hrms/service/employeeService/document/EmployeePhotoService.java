package spring.hrms.service.employeeService.document;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import spring.hrms.DTO.response.DocumentResponse;
import spring.hrms.aws.DownloadUploadService;
import spring.hrms.entity.EmployeeAllData;
import spring.hrms.entity.employee.EmployeePersonal;
import spring.hrms.entity.employee.document.EmployeePhoto;
import spring.hrms.repository.employeeRepo.EmployeePersonalRepo;
import spring.hrms.repository.employeeRepo.document.EmployeePhotoRepo;
import spring.hrms.temporaryStorage.TemporaryStorage;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeePhotoService {
    @Value("${project.domainName}")
    private String domainName;
    private final DownloadUploadService downloadUploadService;
    private final EmployeePhotoRepo repository;
    private final EmployeePersonalRepo employeePersonalRepo;
    private final List<EmployeeAllData>temporaryStorage = TemporaryStorage.allEmployees;

    public void uploadEmployeePhoto(MultipartFile file, Integer storageId) {
        EmployeePersonal employee = temporaryStorage.get(storageId).getEmployeePersonal();
        DocumentResponse response = downloadUploadService.uploadFile(file);
        EmployeePhoto photo = new EmployeePhoto();
        photo.setFileType(response.getFileType());
        photo.setOriginalName(file.getOriginalFilename());
        photo.setServerName(response.getServerName());
        photo.setEmployeePersonal(employee);
        photo.setDownloadUrl(domainName+"employee-photo/" + response.getServerName());
        photo.setSize(file.getSize());
        temporaryStorage.get(storageId).setPhoto(photo);
    }

    public DocumentResponse downloadEmployeePhoto(String serverName) {
        EmployeePhoto employeePhoto = repository.findByServerName(serverName).orElseThrow(() -> new EntityNotFoundException("entity not found" + serverName));
        byte[] file = downloadUploadService.downloadFile(serverName);
        return DocumentResponse.builder()
                .file(file)
                .fileType(employeePhoto.getFileType())
                .originalName(employeePhoto.getOriginalName())
                .build();
    }
public DocumentResponse updateEmployeePhoto(MultipartFile file, Integer employeeId) {
    EmployeePersonal employee = employeePersonalRepo.findById(employeeId).orElseThrow(() -> new EntityNotFoundException("entity not found" + employeeId));
    DocumentResponse response = downloadUploadService.uploadFile(file);
    EmployeePhoto photo = getEmployeePhoto(file, response, employee);
    EmployeePhoto save = repository.save(photo);
    System.out.println("filetype is "+save.getFileType()+"\n\n\n\n\n\n");
    return DocumentResponse.builder()
            .downloadUrl(save.getDownloadUrl())
            .size(save.getSize())
            .originalName(save.getOriginalName())
            .documentId(save.getId())
            .build();

}

    private EmployeePhoto getEmployeePhoto(MultipartFile file, DocumentResponse response, EmployeePersonal employee) {
        var serverName = response.getServerName();
        EmployeePhoto photo = new EmployeePhoto();
        photo.setOriginalName(file.getOriginalFilename());
        photo.setServerName(serverName);
        photo.setEmployeePersonal(employee);
        photo.setDownloadUrl(domainName+"employee-photo/" + serverName);
        photo.setSize(file.getSize());
        photo.setFileType(response.getFileType());
        EmployeePhoto photo1 = employee.getEmployeePhoto();
        if (photo1 != null) {
            photo.setId(photo1.getId());
        }
        return photo;
    }

    public DocumentResponse getPhotoLink(Integer employeeId) {
        EmployeePhoto employeePhoto = employeePersonalRepo.findById(employeeId).orElseThrow(() -> new EntityNotFoundException("entity not found" + employeeId)).getEmployeePhoto();
        return DocumentResponse.builder()
                .downloadUrl(employeePhoto.getDownloadUrl())
                .originalName(employeePhoto.getOriginalName())
                .size(employeePhoto.getSize())
                .build();

    }
}
