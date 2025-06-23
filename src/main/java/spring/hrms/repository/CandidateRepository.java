package spring.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import spring.hrms.entity.employee.Candidate;
@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> , JpaSpecificationExecutor<Candidate> {
}


