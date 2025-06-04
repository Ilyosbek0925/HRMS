package spring.hrms.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.hrms.entity.status.ResponseStatus;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponseDto {
    private ResponseStatus status;
    private String message;
    private LocalDateTime timestamp;
}
