package spring.hrms.service.employeeService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.hrms.DTO.request.EmployeePersonalRequest;
import spring.hrms.DTO.response.EmployeePersonalResponse;
import spring.hrms.entity.EmployeeAllData;
import spring.hrms.entity.employee.EmployeePersonal;
import spring.hrms.mapper.EmployeePersonalMapper;
import spring.hrms.repository.employeeRepo.EmployeePersonalRepo;
import spring.hrms.temporaryStorage.TemporaryStorage;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeePersonalService {
    private final EmployeePersonalMapper mapper;
    private final EmployeePersonalRepo repo;
    List<EmployeeAllData> temporaryStorage = TemporaryStorage.allEmployees;
    private int storageId = 0;

    public EmployeePersonalResponse addEmployeePersonal(EmployeePersonalRequest employeePersonalRequest) {
        EmployeePersonal employeePersonal = mapper.toEmployeePersonal(employeePersonalRequest);
        EmployeeAllData build = EmployeeAllData.builder()
                .employeePersonal(employeePersonal)
                .build();
        temporaryStorage.add(build);
        storageId++;
        EmployeePersonalResponse employeePersonalResponse = mapper.toEmployeePersonalResponse(employeePersonal);
        employeePersonalResponse.setStorageId(storageId);
        return employeePersonalResponse;
    }


    public EmployeePersonalResponse getEmployeePersonal(Integer employeeId) {
        EmployeePersonal employee = repo.findById(employeeId).orElseThrow(() -> new RuntimeException("employee not found"));
        return mapper.toEmployeePersonalResponse(employee);
    }

    public EmployeePersonalResponse updateEmployeePersonal(Integer employeeId, EmployeePersonalRequest employeePersonalRequest) {
        EmployeePersonal employeePersonal;
        if (repo.existsById(employeeId)) {
            employeePersonal = mapper.toEmployeePersonal(employeePersonalRequest);
            employeePersonal.setId(employeeId);
        } else {
            throw new RuntimeException("employee not found");
        }

        return mapper.toEmployeePersonalResponse(employeePersonal);
    }


    public void deleteEmployee(Integer employeeId) {
        if(repo.existsById(employeeId)) {

        repo.deleteById(employeeId);

        }else  {
            throw new RuntimeException("employee not found");
        }


    }
}
