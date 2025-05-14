package spring.hrms.service.employeeService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.hrms.DTO.request.EmployeeProfessionalRequest;
import spring.hrms.DTO.response.EmployeeProfessionalResponse;
import spring.hrms.entity.EmployeeAllData;
import spring.hrms.entity.employee.EmployeeProfessional;
import spring.hrms.mapper.EmployeeProfessionalMapper;
import spring.hrms.repository.employeeRepo.EmployeeProfessionalRepo;
import spring.hrms.temporaryStorage.TemporaryStorage;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeProfessionalService {
    private final EmployeeProfessionalMapper mapper;
    private final EmployeeProfessionalRepo repo;
    private List<EmployeeAllData> temporaryStorage = TemporaryStorage.allEmployees;

    public EmployeeProfessionalResponse addProfessional(int storageId, EmployeeProfessionalRequest request) {
        EmployeeProfessional employeeProfessional = mapper.toEmployeeProfessional(request);
        temporaryStorage.get(storageId).setEmployeeProfessional(employeeProfessional);
        return mapper.toEmployeeProfessionalResponse(employeeProfessional, storageId);
    }


}
