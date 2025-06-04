package spring.hrms.DTO.response;

import lombok.Builder;
import lombok.Value;
import spring.hrms.entity.status.ProjectStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * DTO for {@link spring.hrms.entity.Project}
 */
@Value
@Builder
public class ProjectResponse  {
    Integer projectId;
    LocalDateTime created;
    String name;
    LocalDate startDate;
    LocalDate endDate;
    ProjectStatus status;
}