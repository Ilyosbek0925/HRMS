package spring.hrms.DTO.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DocumentResponse {
    private Integer documentId;
    private String downloadUrl;
    private String serverName;
    private byte[] file;
    private String fileType;
    private String originalName;
    private double size;

}
