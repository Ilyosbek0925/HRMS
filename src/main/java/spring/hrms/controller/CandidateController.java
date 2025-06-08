package spring.hrms.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.hrms.DTO.ApiResponseDto;
import spring.hrms.DTO.request.CandidateRequest;
import spring.hrms.DTO.response.CandidateResponse;
import spring.hrms.entity.employee.Candidate;
import spring.hrms.entity.status.ResponseStatus;
import spring.hrms.service.CandidateService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("candidate")
@RequiredArgsConstructor
public class CandidateController {
    private final CandidateService service;

    @PostMapping
    public ResponseEntity<CandidateResponse> addCandidate(@RequestBody CandidateRequest candidate) {
        CandidateResponse response = service.addCandidate(candidate);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<Candidate>> getAllCandidates(@RequestParam(required = false, defaultValue = "0") int page, @RequestParam(required = false, defaultValue = "10") int size) {
        Page<Candidate> all = service.getAll(page, size);
        return ResponseEntity.ok(all);
    }

    @PutMapping("/{candidateId}")
    public ResponseEntity<CandidateResponse> updateCandidate(@PathVariable int candidateId, @RequestBody CandidateRequest candidate) {
        CandidateResponse response = service.update(candidateId, candidate);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{candidateId}")
    public ResponseEntity<ApiResponseDto> deleteCandidate(@PathVariable int candidateId) {
        service.delete(candidateId);
        return ResponseEntity.ok(new ApiResponseDto(ResponseStatus.SUCCESS, "deleted successfully", LocalDateTime.now()));
    }

    @GetMapping("filter")
    public ResponseEntity<CandidateResponse> filter(@RequestParam(required = false) String name,
                                                    @RequestParam(required = false) String appliedFor,
                                                    @RequestParam(required = false) String status){

return null;


    }


}
