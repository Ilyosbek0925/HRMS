package spring.hrms.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import spring.hrms.entity.Holiday;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface HolidayRepository extends JpaRepository<Holiday, Integer>, JpaSpecificationExecutor<Holiday> {
    Optional<Holiday>findByHolidayDate(LocalDate holidayDate);
}
