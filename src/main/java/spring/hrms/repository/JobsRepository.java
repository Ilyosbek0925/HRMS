package spring.hrms.repository;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import spring.hrms.entity.Job;
@Repository
public interface JobsRepository extends JpaRepository<Job, Integer>, JpaSpecificationExecutor<Job> {
}
