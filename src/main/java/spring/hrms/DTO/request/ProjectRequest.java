package spring.hrms.DTO.request;

import lombok.Data;
import spring.hrms.entity.status.ProjectStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
public class ProjectRequest {
    LocalDateTime created;
    String name;
    LocalDate startDate;
    LocalDate endDate;
    ProjectStatus status;
}
