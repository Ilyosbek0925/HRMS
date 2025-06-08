package spring.hrms.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.hrms.entity.employee.Candidate;
@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
}


