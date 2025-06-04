package spring.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.hrms.entity.Project;

public interface ProjectsRepository extends JpaRepository<Project, Integer> {
}
