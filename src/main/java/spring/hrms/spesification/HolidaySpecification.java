package spring.hrms.spesification;

import org.springframework.data.jpa.domain.Specification;
import spring.hrms.entity.Holiday;
import spring.hrms.entity.Job;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class HolidaySpecification {

    public static Specification<Holiday> hasDate(String localDate) {
        if(localDate==null){
            return (root, query, criteriaBuilder) -> criteriaBuilder.conjunction();
        }
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("date"), localDate);
    }

    public static Specification<Holiday> hasDay(String dayOfWeek) {
        if(dayOfWeek==null){
            return (root, query, criteriaBuilder) -> criteriaBuilder.conjunction();
        }
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get("dayOfWeek")), dayOfWeek.toLowerCase()+"%");
    }

    public static Specification<Holiday> hasHolidayName(String holidayName) {
        if(holidayName==null){
            return (root, query, criteriaBuilder) -> criteriaBuilder.conjunction();
        }
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get("holidayName")), holidayName.toLowerCase()+"%");
    }




}
