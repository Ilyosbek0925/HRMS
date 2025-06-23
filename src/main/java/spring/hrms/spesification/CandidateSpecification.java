package spring.hrms.spesification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import spring.hrms.entity.employee.Candidate;

@Component
public class CandidateSpecification {


    public static Specification<Candidate> hasAppliedFor(String appliedFor) {
        if (appliedFor == null) {
            return (root, query, criteriaBuilder) -> criteriaBuilder.conjunction();
        }
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get("appliedFor")), appliedFor.toLowerCase() + "%");
    }


}
