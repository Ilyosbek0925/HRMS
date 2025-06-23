package spring.hrms.service.employeeService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import spring.hrms.DTO.projection.EmployeeProjection;
import spring.hrms.entity.employee.EmployeePersonal;
import spring.hrms.repository.employeeRepo.EmployeePersonalRepo;
import spring.hrms.spesification.EmployeeSpecification;
import spring.hrms.spesification.GenericSpesification;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeePersonalRepo repository;

    public Page<EmployeeProjection> getEmployee(Integer page, Integer size) {
        return repository.getEmployeeProjections(PageRequest.of(page, size));
    }

    public List<EmployeeProjection> filter(String name, String department, String designation, String type, String status) {
        Specification<EmployeePersonal> specification = Specification.where(EmployeeSpecification.hasType(type))
                .and(EmployeeSpecification.hasName(name)).and(GenericSpesification.hasDepartment(department))
                .and(GenericSpesification.hasDesignation(designation)).and(GenericSpesification.hasStatus(status));

return  repository.findAll(specification).stream().map(spe -> {
            EmployeeProjection projection = new EmployeeProjection();
            projection.setEmployeeId(spe.getId());
            projection.setFirstName(spe.getFirstName());
            projection.setLastName(spe.getLastName());
            projection.setDesignation(spe.getEmployeeProfessional().getDesignation());
            projection.setDepartment(spe.getEmployeeProfessional().getDepartment());
            projection.setDownloadUrl(spe.getEmployeePhoto().getDownloadUrl());
            return projection;
        }).toList();
    }


}