package spring.hrms.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import spring.hrms.DTO.request.ProjectRequest;
import spring.hrms.DTO.response.ProjectResponse;
import spring.hrms.entity.Project;
import spring.hrms.entity.employee.EmployeePersonal;
import spring.hrms.repository.employeeRepo.EmployeePersonalRepo;

@Component
@RequiredArgsConstructor
public class ProjectMapper {
    private final EmployeePersonalRepo employeeRepo;

    public Project toProject(int employeeId, ProjectRequest projectDto) {
        Project project = new Project();
        project.setName(projectDto.getName());
        project.setStatus(projectDto.getStatus());
        EmployeePersonal employee = employeeRepo.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found"));
        project.setEmployeePersonal(employee);
        return project;
    }


    public ProjectResponse toProjectResponse(Project project) {
        return ProjectResponse.builder()
                .name(project.getName())
                .status(project.getStatus())
                .projectId(project.getId())
                .startDate(project.getStartDate())
                .endDate(project.getEndDate())
                .created(project.getCreated())
                .build();
    }
}
