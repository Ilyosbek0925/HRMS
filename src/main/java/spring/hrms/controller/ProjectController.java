package spring.hrms.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.hrms.DTO.ApiResponseDto;
import spring.hrms.DTO.request.ProjectRequest;
import spring.hrms.DTO.response.ProjectResponse;
import spring.hrms.entity.status.ResponseStatus;
import spring.hrms.service.ProjectService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService service;

    @PostMapping("/{employeeId}")
    public ResponseEntity<ProjectResponse> addProject(@PathVariable int employeeId, @RequestBody ProjectRequest projectDto) {
        ProjectResponse response = service.addProject(employeeId, projectDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<List<ProjectResponse>> getEmployeeProjects(@PathVariable int employeeId) {
        List<ProjectResponse> responseList = service.getAllProjects(employeeId);
        return ResponseEntity.status(HttpStatus.OK).body(responseList);
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<ProjectResponse> updateProject(@PathVariable int projectId, @RequestBody ProjectRequest projectDto) {
        ProjectResponse response = service.updateProject(projectId, projectDto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @DeleteMapping("/{projectId}")
    public ResponseEntity<ApiResponseDto> deleteProject(@PathVariable int projectId) {
        service.deleteProject(projectId);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseDto(ResponseStatus.SUCCESS, "deleted successfully", LocalDateTime.now()));
    }

}
