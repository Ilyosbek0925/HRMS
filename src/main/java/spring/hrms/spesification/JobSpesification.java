package spring.hrms.spesification;

import org.springframework.data.jpa.domain.Specification;
import spring.hrms.entity.Job;

public class JobSpesification {


    public static Specification<Job> hasStatus(String status) {
        if(status==null){
            return (root, query, criteriaBuilder) -> criteriaBuilder.conjunction();
        }
        return (root, query, criteriaBuilder) -> {

            if (!status.isEmpty()) {
                return criteriaBuilder.like(criteriaBuilder.lower(root.get("status")), status.toLowerCase());
            } else {
                return criteriaBuilder.conjunction();
            }
        };
    }


    public static Specification<Job> hasTitle(String title) {
        if(title==null){
            return (root, query, criteriaBuilder) -> criteriaBuilder.conjunction();
        }
        return (root, query, criteriaBuilder) -> {

            if (!title.isEmpty()) {
                return criteriaBuilder.like(criteriaBuilder.lower(root.get("jobTitle")), title+"%");
            } else {
                return criteriaBuilder.conjunction();
            }
        };
    }

    public static Specification<Job> hasDepartment(String department) {
        if(department==null){
            return (root, query, criteriaBuilder) -> criteriaBuilder.conjunction();
        }
        return (root, query, criteriaBuilder) -> {

            if (!department.isEmpty()) {
                return criteriaBuilder.like(criteriaBuilder.lower(root.get("department")), department+"%");
            } else {
                return criteriaBuilder.conjunction();
            }
        };
    }

}
