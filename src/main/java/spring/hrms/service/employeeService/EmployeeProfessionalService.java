package spring.hrms.service.employeeService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.hrms.DTO.request.EmployeeProfessionalRequest;
import spring.hrms.DTO.response.EmployeeProfessionalResponse;
import spring.hrms.entity.EmployeeAllData;
import spring.hrms.entity.employee.EmployeePersonal;
import spring.hrms.entity.employee.EmployeeProfessional;
import spring.hrms.exception.UserNotFoundException;
import spring.hrms.mapper.EmployeeProfessionalMapper;
import spring.hrms.repository.employeeRepo.EmployeePersonalRepo;
import spring.hrms.repository.employeeRepo.EmployeeProfessionalRepo;
import spring.hrms.temporaryStorage.TemporaryStorage;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeProfessionalService {
    private final EmployeeProfessionalMapper mapper;
    private final EmployeeProfessionalRepo repo;
    private final EmployeePersonalRepo personalRepo;
    private final List<EmployeeAllData> temporaryStorage = TemporaryStorage.allEmployees;

    public EmployeeProfessionalResponse addProfessional(int storageId, EmployeeProfessionalRequest request) {
        EmployeeProfessional employeeProfessional = mapper.toEmployeeProfessional(request);
        EmployeePersonal employeePersonal = temporaryStorage.get(storageId).getEmployeePersonal();
        employeeProfessional.setEmployeePersonal(employeePersonal);
        temporaryStorage.get(storageId).setEmployeeProfessional(employeeProfessional);
        return mapper.toEmployeeProfessionalResponse(employeeProfessional, storageId);
    }

    public EmployeeProfessionalResponse getEmployee(Integer employeeId) {
        EmployeeProfessional employee = repo.findById(employeeId).orElseThrow(() -> new UserNotFoundException("Employee not found with id "+employeeId));
        return mapper.toEmployeeProfessionalResponse(employee, employeeId);
    }

    public EmployeeProfessionalResponse update(Integer employeeId, EmployeeProfessionalRequest request) {
        Integer professionalId = personalRepo.findById(employeeId).
                orElseThrow(() -> new UserNotFoundException("Employee not found with id "+employeeId)).getEmployeeProfessional().getId();
        EmployeeProfessional employeeProfessional = mapper.toEmployeeProfessional(request);
        employeeProfessional.setId(professionalId);
        return mapper.toEmployeeProfessionalResponse(employeeProfessional, employeeId);
    }
}
