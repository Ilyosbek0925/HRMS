package spring.hrms.spesification;

import org.springframework.data.jpa.domain.Specification;
import spring.hrms.entity.employee.Attendance;

public class GenericSpesification {
    public static <T> Specification<T> hasStatus(String status) {
        return (root, query, criteriaBuilder) -> {
            if (status == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("status")), status.toLowerCase() + "%");
        };
    }


    public static <T> Specification<T> hasName(String name) {
        if (name == null) {
            return (root, query, criteriaBuilder) -> criteriaBuilder.conjunction();
        }
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), name.toLowerCase() + "%");
    }


    public static <T>Specification<T> hasDepartment(String department) {
        if (department == null) {
            return (root, query, criteriaBuilder) -> criteriaBuilder.conjunction();
        }
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get("employeeProfessional").get("department")), department.toLowerCase() + "%");
    }


    public static <T>Specification<T> hasDesignation(String designation) {
        if (designation == null) {
            return (root, query, criteriaBuilder) -> criteriaBuilder.conjunction();
        }
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get("employeeProfessional").get("designation")), designation.toLowerCase() + "%");
    }


}
