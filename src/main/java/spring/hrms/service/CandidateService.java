package spring.hrms.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import spring.hrms.DTO.request.CandidateRequest;
import spring.hrms.DTO.response.CandidateResponse;
import spring.hrms.exception.UserNotFoundException;
import spring.hrms.repository.CandidateRepository;
import spring.hrms.entity.employee.Candidate;
import spring.hrms.mapper.CandidateMapper;
import spring.hrms.spesification.CandidateSpecification;
import spring.hrms.spesification.GenericSpesification;

import java.util.List;
import java.util.stream.Collectors;

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
        } else throw new UserNotFoundException("candidate not found with id "+candidateId);
    }

    public void delete(int candidateId) {
        if (repository.existsById(candidateId)) {
            repository.deleteById(candidateId);
        }else throw new UserNotFoundException("candidate not found with id "+candidateId);
    }

    public List<CandidateResponse> filter(String name, String appliedFor, String status) {
        List<Candidate> all = repository.findAll(Specification.where(CandidateSpecification.hasAppliedFor(appliedFor)).and(GenericSpesification.hasName(name)).and(GenericSpesification.hasStatus(status)));
        return all.stream().map(mapper::toCandidateResponse).collect(Collectors.toList());

    }
}

