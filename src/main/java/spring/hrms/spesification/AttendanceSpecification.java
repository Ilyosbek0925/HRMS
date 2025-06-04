package spring.hrms.spesification;

import org.springframework.data.jpa.domain.Specification;
import spring.hrms.entity.employee.Attendance;

import java.time.LocalDate;
import java.time.LocalTime;

public class AttendanceSpecification {
    public static Specification<Attendance> hasName(String name) {

        if(name==null){
            return (root, query, criteriaBuilder) -> criteriaBuilder.conjunction();
        }
        var firstName = name.split(" ")[0].toLowerCase()+"%";
        String lastName = "";
        try {
            lastName = name.split(" ")[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        if (!lastName.isEmpty()) {
            String finalLastName = lastName.toLowerCase()+"%";
            return (root, query, criteriaBuilder) -> {
                criteriaBuilder.equal(criteriaBuilder.lower(root.get("employeePersonal").get("firstName")), firstName);
                return criteriaBuilder.and(criteriaBuilder.like(criteriaBuilder.lower(root.get("employeePersonal").get("lastName")), finalLastName));
            };
        }
        return (root, query, criteriaBuilder) ->criteriaBuilder.like(criteriaBuilder.lower(root.get("employeePersonal").get("firstName")), firstName);
    }

    public static Specification<Attendance> hasStatus(String status) {
        if(status==null){
            return (root, query, criteriaBuilder) -> criteriaBuilder.conjunction();
        }
        return (root, query, criteriaBuilder) -> {

            if (!status.isEmpty()) {
                return criteriaBuilder.equal(root.get("status"), status);
            } else {
                return criteriaBuilder.conjunction();
            }
        };
    }

    public static Specification<Attendance> hasDate(LocalDate minDate, LocalDate maxDate) {
        return (root, query, criteriaBuilder) -> {
            if (minDate != null && maxDate != null) {
                return criteriaBuilder.between(root.get("date"), minDate, maxDate);
            }
            if (minDate != null) {
                return criteriaBuilder.equal(root.get("date"), minDate);
            }
            if (maxDate != null) {
                return criteriaBuilder.equal(root.get("date"), maxDate);
            }
            return criteriaBuilder.conjunction();
        };
    }

    public static Specification<Attendance> hasTime(LocalTime minTime, LocalTime maxTime) {

        return (root, query, criteriaBuilder) -> {

            if (minTime != null && maxTime != null) {
                return criteriaBuilder.between(root.get("checkIn"), minTime, maxTime);
            }
            if (minTime != null) {
                return criteriaBuilder.equal(root.get("checkIn"), minTime);
            }
            if (maxTime != null) {
                return criteriaBuilder.equal(root.get("checkIn"), maxTime);
            }
            return criteriaBuilder.conjunction();
        };
    }





}




