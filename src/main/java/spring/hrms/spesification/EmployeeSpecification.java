package spring.hrms.spesification;

import org.springframework.data.jpa.domain.Specification;
import spring.hrms.entity.employee.EmployeePersonal;

public class EmployeeSpecification {
    public static Specification<EmployeePersonal> hasName(String name) {
        if (name != null) {
            var firstName = name.split(" ")[0].toLowerCase() + "%";
            String lastName = "";
            try {
                lastName = name.split(" ")[1];
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
            if (!lastName.isEmpty()) {
                String finalLastName = lastName.toLowerCase() + "%";
                return (root, query, criteriaBuilder) -> {
                    criteriaBuilder.equal(criteriaBuilder.lower(root.get("employeePersonal").get("firstName")), firstName);
                    return criteriaBuilder.and(criteriaBuilder.like(criteriaBuilder.lower(root.get("employeePersonal").get("lastName")), finalLastName));
                };
            }
            return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get("firstName")), firstName);
        } else {
            return (root, query, criteriaBuilder) -> criteriaBuilder.conjunction();
        }


    }




    public static Specification<EmployeePersonal> hasType(String type) {
        if (type == null) {
            return (root, query, criteriaBuilder) -> criteriaBuilder.conjunction();
        }
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get("employeeProfessional").get("employeeType")), type.toLowerCase() + "%");
    }

}
