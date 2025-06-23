package spring.hrms.controller;

import jakarta.servlet.ServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.hrms.DTO.ApiResponseDto;
import spring.hrms.DTO.request.JobRequest;
import spring.hrms.DTO.request.JobUpdateRequest;
import spring.hrms.DTO.response.JobResponse;
import spring.hrms.entity.status.ResponseStatus;
import spring.hrms.repository.JobsRepository;
import spring.hrms.service.JobService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("job")
@RequiredArgsConstructor
public class JobController {
    private final JobService jobService;

    @PostMapping
    public ResponseEntity<JobResponse> addJob(@RequestBody JobRequest jobRequest) {
        JobResponse jobResponse = jobService.addJob(jobRequest);
        return ResponseEntity.ok(jobResponse);
    }

    @GetMapping
    public ResponseEntity<List<JobResponse>> getJobs() {
        List<JobResponse> allJobs = jobService.findAll();
        return ResponseEntity.ok(allJobs);
    }

    @DeleteMapping
    public ResponseEntity<ApiResponseDto> deleteJob(@RequestBody JobRequest jobRequest) {
        jobService.deleteJob(jobRequest);
        return ResponseEntity.ok(new ApiResponseDto(ResponseStatus.SUCCESS, "successfully deleted", LocalDateTime.now()));
    }

    @GetMapping("filter")
    public ResponseEntity<List<JobResponse>> filterJobs(@RequestParam(required = false) String title,
                                                        @RequestParam(required = false) String department,
                                                        @RequestParam(required = false) String status) {
        List<JobResponse> responses = jobService.filter(department, title, status);
        return ResponseEntity.ok(responses);
    }

    @PutMapping("{jobId}")
    public ResponseEntity<JobResponse> updateJob(@PathVariable Integer jobId, @RequestBody JobUpdateRequest jobRequest) {
        JobResponse jobResponse = jobService.updateJob(jobId, jobRequest);
        return ResponseEntity.ok(jobResponse);
    }


}
