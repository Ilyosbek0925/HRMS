package spring.hrms.aws;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import spring.hrms.DTO.response.DocumentResponse;

import java.io.IOException;
import java.util.UUID;

@Service
public class DownloadUploadService {
    @Autowired
    AmazonS3 amazonS3;

    public DocumentResponse uploadFile(MultipartFile multipartFile) {
        String serverName = UUID.randomUUID().toString().replace("-", "");
        String originalFilename = multipartFile.getOriginalFilename();
        var fileType = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        serverName = serverName + originalFilename.substring(originalFilename.lastIndexOf("."));
        String type = fileType(fileType);
        ObjectMetadata metadata = new ObjectMetadata();
        try {
            amazonS3.putObject("mybacket18784", serverName, multipartFile.getInputStream(), metadata);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("✅ File uploaded successfully!");
        return DocumentResponse.builder()
                .serverName(serverName)
                .fileType(type)
                .build();
    }

    public byte[] downloadFile(String serverName) {
        S3Object s3Object = amazonS3.getObject("mybacket18784", serverName);
        byte[] content = null;
        try {
            S3ObjectInputStream inputStream = s3Object.getObjectContent();
            content = IOUtils.toByteArray(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public String fileType(String type) {
        type = switch (type.toLowerCase()) {
            case "png" -> "image/png";
            case "jpg" -> "image/jpeg";
            case "gif" -> "image/gif";
            case "pdf" -> "application/pdf";
            case "doc" -> "application/msword";
            case "txt" -> "text/plain";
            default -> "application/octet-stream";
        };
        return type;
    }


}
