package spring.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.hrms.entity.Projects;

public interface ProjectsRepository extends JpaRepository<Projects, Integer> {
}
