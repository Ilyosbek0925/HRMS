package spring.hrms.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.hrms.DTO.request.JobRequest;
import spring.hrms.DTO.response.JobResponse;
import spring.hrms.repository.JobsRepository;
import spring.hrms.service.JobService;

import java.util.List;

@RestController
@RequestMapping("job")
@RequiredArgsConstructor
public class JobController {
    private final JobService jobService;

    @PostMapping("addJob")
    public ResponseEntity addJob(@RequestBody JobRequest jobRequest) {
        JobResponse jobResponse = jobService.addJob(jobRequest);
        return ResponseEntity.ok(jobResponse);
    }

    @GetMapping("getJobs")
    public ResponseEntity<List<JobResponse>> getJobs() {
        List<JobResponse> allJobs = jobService.findAll();
        return ResponseEntity.ok(allJobs);
    }

    @DeleteMapping
    public ResponseEntity deleteJob(@RequestBody JobRequest jobRequest) {
        jobService.deleteJob(jobRequest);
        return ResponseEntity.ok(204);
    }


}
