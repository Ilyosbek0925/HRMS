package spring.hrms.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.hrms.DTO.request.JobRequest;
import spring.hrms.DTO.response.JobResponse;
import spring.hrms.entity.Job;
import spring.hrms.entity.JobRepository;
import spring.hrms.mapper.JobMapper;
import spring.hrms.repository.JobsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobService {
private final JobsRepository jobsRepository;
private final JobMapper jobMapper;
    private final JobRepository jobRepository;

    public JobResponse addJob(JobRequest jobRequest) {
        Job save = jobsRepository.save(jobMapper.toJob(jobRequest));
        return jobMapper.toJobResponse(save);
    }

    public List<JobResponse> findAll() {
        List<Job> all = jobsRepository.findAll();
        return jobMapper.toJobResponses(all);
    }


    public void deleteJob(JobRequest jobRequest) {
    jobRepository.delete(jobMapper.toJob(jobRequest));
    }
}
