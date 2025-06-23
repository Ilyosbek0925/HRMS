package spring.hrms.repository.employeeRepo.document;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.hrms.entity.employee.document.Document;

import java.util.Optional;

@Repository
public interface DocumentRepo extends JpaRepository<Document, Integer> {


    Optional<Document> findByServerName(String serverName);

}
