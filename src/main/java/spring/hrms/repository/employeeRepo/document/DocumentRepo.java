package spring.hrms.repository.employeeRepo.document;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.hrms.entity.employee.document.Document;

import java.util.List;

@Repository
public interface DocumentRepo extends JpaRepository<Document, Integer> {


}
