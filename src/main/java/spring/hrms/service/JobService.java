package spring.hrms.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import spring.hrms.DTO.request.JobRequest;
import spring.hrms.DTO.request.JobUpdateRequest;
import spring.hrms.DTO.response.JobResponse;
import spring.hrms.entity.Job;
import spring.hrms.entity.status.JobStatus;
import spring.hrms.mapper.JobMapper;
import spring.hrms.repository.JobsRepository;
import spring.hrms.spesification.JobSpesification;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobService {
    private final JobsRepository jobsRepository;
    private final JobMapper jobMapper;

    public JobResponse addJob(JobRequest jobRequest) {
        Job job = jobMapper.toJob(jobRequest);
        job.setStatus(JobStatus.ACTIVE_JOBS);
        Job save = jobsRepository.save(job);
        return jobMapper.toJobResponse(save);
    }

    public List<JobResponse> findAll() {
        List<Job> all = jobsRepository.findAll();
        return jobMapper.toJobResponses(all);
    }


    public void deleteJob(JobRequest jobRequest) {
        jobsRepository.delete(jobMapper.toJob(jobRequest));
    }

    public List<JobResponse> filter(String department, String title, String status) {
        List<Job> all = jobsRepository.findAll(Specification.where(JobSpesification.hasTitle(title)).and(JobSpesification.hasStatus(status)).and(JobSpesification.hasDepartment(department)));
        return jobMapper.toJobResponses(all);
    }

    public JobResponse updateJob(Integer jobId, JobUpdateRequest jobRequest) {
        Job job = jobMapper.toJob(jobRequest);
        job.setId(jobId);
        jobsRepository.save(job);
        return jobMapper.toJobResponse(job);
    }
}
