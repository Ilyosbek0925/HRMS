package spring.hrms.spesification;

import org.springframework.data.jpa.domain.Specification;

public class GenericSpesification {

    public class GenericSpecification {

        public static <T> Specification<T> hasStatus(String status) {
            return (root, query, criteriaBuilder) -> {
                if (status == null) {
                    return criteriaBuilder.conjunction();
                }
                return criteriaBuilder.like(root.get(status), status + "%");
            };
        }
    }



    public static <T> Specification<T> hasName(String name) {
        if (name == null) {
            return (root, query, criteriaBuilder) -> criteriaBuilder.conjunction();
        }
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), name.toLowerCase() + "%");
    }


}
