package spring.hrms.repository.managerRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.hrms.entity.manager.Manager;

import java.util.Optional;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {
    Optional<Manager> findByEmail(String email);

    boolean existsByEmail(String email);

}
