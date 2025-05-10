package spring.hrms.repository.managerRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.hrms.entity.manager.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {
}
