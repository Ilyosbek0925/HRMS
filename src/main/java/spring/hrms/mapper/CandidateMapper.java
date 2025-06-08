package spring.hrms.mapper;

import org.springframework.stereotype.Component;
import spring.hrms.DTO.request.CandidateRequest;
import spring.hrms.DTO.response.CandidateResponse;
import spring.hrms.entity.employee.Candidate;

import java.time.LocalDate;

@Component
public class CandidateMapper {
public Candidate toCandidate(CandidateRequest request){
    Candidate candidate = new Candidate();
    candidate.setName(request.getName());
    candidate.setAppliedFor(request.getAppliedFor());
    candidate.setPhone(request.getPhone());
    candidate.setEmail(request.getEmail());
    candidate.setStatus(request.getStatus());
    candidate.setAppliedDate(LocalDate.now());
    return candidate;
}

public CandidateResponse toCandidateResponse(Candidate candidate) {
    return CandidateResponse.builder()
            .id(candidate.getId())
            .name(candidate.getName())
            .phone(candidate.getPhone())
            .email(candidate.getEmail())
            .status(candidate.getStatus())
            .appliedDate(candidate.getAppliedDate())
            .appliedFor(candidate.getAppliedFor())
            .build();
}
}
