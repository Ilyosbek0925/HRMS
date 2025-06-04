package spring.hrms.mapper;

import org.springframework.stereotype.Component;
import spring.hrms.DTO.response.DocumentResponse;
import spring.hrms.entity.employee.document.Document;

@Component
public class DocumentMapper {
    public DocumentResponse toDocumentResponse(Document document) {
        return DocumentResponse.builder()
                .documentId(document.getId())
                .serverName(document.getServerName())
                .fileType(document.getFileType())
                .downloadUrl(document.getDownloadUrl())
                .originalName(document.getOriginalName())
                .build();
    }
}
