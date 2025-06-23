package spring.hrms.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.hrms.DTO.request.EmployeeLeaveRequest;
import spring.hrms.DTO.response.EmployeeLeaveResponse;
import spring.hrms.entity.employee.EmployeeLeave;
import spring.hrms.mapper.LeaveMapper;
import spring.hrms.repository.LeaveRepository;
import spring.hrms.repository.employeeRepo.EmployeePersonalRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LeaveService {
    private final LeaveRepository repository;
    private final EmployeePersonalRepo personalRepo;
    private final LeaveMapper mapper;

    public EmployeeLeaveResponse addLeave(int employeeId, EmployeeLeaveRequest employeeLeaveRequest) {
        EmployeeLeave employeeLeave = mapper.toEmployeeLeave(employeeId, employeeLeaveRequest);
        return mapper.toEmployeeLeaveResponse(repository.save(employeeLeave));
    }

    public List<EmployeeLeaveResponse> getLeave(int employeeId) {
        List<EmployeeLeave> employeeLeaves = personalRepo.findById(employeeId).orElseThrow(() -> new EntityNotFoundException("Employee not found")).getEmployeeLeaves();
        return employeeLeaves.stream().map(mapper::toEmployeeLeaveResponse).collect(Collectors.toList());
    }

    public EmployeeLeaveResponse update(int leaveId, EmployeeLeaveRequest employeeLeaveRequest) {
        Integer employeeId = repository.findById(leaveId).orElseThrow(() -> new EntityNotFoundException("Leave not found with id "+ leaveId)).getEmployeePersonal().getId();
        EmployeeLeave employeeLeave = mapper.toEmployeeLeave(employeeId, employeeLeaveRequest);
        employeeLeave.setId(leaveId);
        return mapper.toEmployeeLeaveResponse(repository.save(employeeLeave));
    }
    public void deleteLeave(int leaveId) {
      if(repository.existsById(leaveId)) {
          repository.deleteById(leaveId);
      }else throw new EntityNotFoundException("Leave not found with id: " + leaveId);
    }
}
