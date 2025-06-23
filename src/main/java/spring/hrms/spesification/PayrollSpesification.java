package spring.hrms.spesification;

import org.springframework.data.jpa.domain.Specification;
import spring.hrms.entity.PayRoll;

public class PayrollSpesification {
    public static Specification<PayRoll>hasPerMonth(Double monthSalary){
        if(monthSalary==null){
            return (root, query, criteriaBuilder) -> criteriaBuilder.conjunction();
        }
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("salaryPerMonth"), monthSalary);
    }



    public static Specification<PayRoll>hasName(String name){
        if(name==null){
            return (root, query, criteriaBuilder) -> criteriaBuilder.conjunction();
        }
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.lower(root.get("employeeName")), name.toLowerCase()+"%");
    }






}
