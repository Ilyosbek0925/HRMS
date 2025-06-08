package spring.hrms.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import spring.hrms.DTO.request.CandidateRequest;
import spring.hrms.DTO.response.CandidateResponse;
import spring.hrms.controller.CandidateRepository;
import spring.hrms.entity.employee.Candidate;
import spring.hrms.mapper.CandidateMapper;

@Service
@RequiredArgsConstructor
public class CandidateService {
    private final CandidateRepository repository;
    private final CandidateMapper mapper;

    public CandidateResponse addCandidate(CandidateRequest candidate) {
        return mapper.toCandidateResponse(repository.save(mapper.toCandidate(candidate)));
    }


    public Page<Candidate> getAll(int page, int size) {
        return repository.findAll(PageRequest.of(page, size));
    }

    public CandidateResponse update(int candidateId, CandidateRequest candidateRequest) {
        if (repository.existsById(candidateId)) {
            Candidate candidate = mapper.toCandidate(candidateRequest);
            candidate.setId(repository.save(candidate).getId());
            return mapper.toCandidateResponse(repository.save(candidate));
        } else throw new RuntimeException("candidate id not found");
    }

    public void delete(int candidateId) {
        if (repository.existsById(candidateId)) {
            repository.delete(repository.findById(candidateId).orElseThrow(() -> new RuntimeException("candidate id not found")));
        }else throw new RuntimeException("candidate id not found");
    }
}

