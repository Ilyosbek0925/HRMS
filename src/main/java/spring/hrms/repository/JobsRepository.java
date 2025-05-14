package spring.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.hrms.entity.Job;
@Repository
public interface JobsRepository extends JpaRepository<Job, Integer> {
}
