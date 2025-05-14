package spring.hrms.mapper;

import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Component;
import spring.hrms.DTO.request.JobRequest;
import spring.hrms.DTO.response.JobResponse;
import spring.hrms.entity.Job;

import java.util.ArrayList;
import java.util.List;

@Component
public class JobMapper {

    public Job toJob(JobRequest jobRequest) {
        Job job = new Job();
        job.setJobTitle(jobRequest.getTitle());
        job.setDepartment(jobRequest.getDepartment());
        job.setAmount(jobRequest.getAmount());
        job.setLocation(jobRequest.getLocation());
        job.setWorkType(jobRequest.getWorkType());
        return job;
    }

    public JobResponse toJobResponse(Job job) {
        return JobResponse.builder()
                .id(job.getId())
                .title(job.getJobTitle())
                .department(job.getDepartment())
                .amount(job.getAmount())
                .location(job.getLocation())
                .workType(job.getWorkType())
                .build();
    }


    public List<JobResponse> toJobResponses(List<Job> jobs) {
        List<JobResponse> jobResponses = jobs.stream().map(this::toJobResponse).toList();
        return jobResponses;
    }


}
