package spring.hrms.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.hrms.DTO.request.ProjectRequest;
import spring.hrms.DTO.response.ProjectResponse;
import spring.hrms.entity.Project;
import spring.hrms.entity.employee.EmployeePersonal;
import spring.hrms.exception.UserNotFoundException;
import spring.hrms.mapper.ProjectMapper;
import spring.hrms.repository.ProjectsRepository;
import spring.hrms.repository.employeeRepo.EmployeePersonalRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectMapper mapper;
    private final ProjectsRepository repository;
    private final EmployeePersonalRepo personalRepo;

    public ProjectResponse addProject(int employeeId, ProjectRequest projectDto) {
        Project project = mapper.toProject(employeeId, projectDto);
        return mapper.toProjectResponse(repository.save(project));
    }

    public List<ProjectResponse> getAllProjects(int employeeId) {
        EmployeePersonal employee = personalRepo.findById(employeeId).orElseThrow(() -> new UserNotFoundException("Employee not found with id "+ employeeId));
        return employee.getProjects().stream().map(mapper::toProjectResponse).collect(Collectors.toList());
    }

    public ProjectResponse updateProject(int projectId, ProjectRequest projectDto) {
        Integer employeeId = repository.findById(projectId).orElseThrow(() -> new EntityNotFoundException("Project not found")).getEmployeePersonal().getId();
        Project project = mapper.toProject(employeeId, projectDto);
        project.setId(projectId);
        return mapper.toProjectResponse(repository.save(project));
    }


    public void deleteProject(int projectId) {
        if (repository.existsById(projectId))
            repository.deleteById(projectId);
        else throw new EntityNotFoundException("Project not found with id " + projectId);
    }


}
