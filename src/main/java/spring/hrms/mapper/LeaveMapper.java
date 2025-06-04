package spring.hrms.mapper;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import spring.hrms.DTO.request.EmployeeLeaveRequest;
import spring.hrms.DTO.response.EmployeeLeaveResponse;
import spring.hrms.entity.employee.EmployeeLeave;
import spring.hrms.entity.employee.EmployeePersonal;
import spring.hrms.repository.LeaveRepository;
import spring.hrms.repository.employeeRepo.EmployeePersonalRepo;

@Component
@RequiredArgsConstructor
public class LeaveMapper {
    private final EmployeePersonalRepo personalRepo;
    public EmployeeLeave toEmployeeLeave(int employeeId,EmployeeLeaveRequest employeeLeaveRequest) {
        EmployeeLeave employeeLeave = new EmployeeLeave();
        employeeLeave.setLeaveStatus(employeeLeaveRequest.getLeaveStatus());
        employeeLeave.setDate(employeeLeaveRequest.getDate());
        employeeLeave.setDays(employeeLeaveRequest.getDays());
        employeeLeave.setDuration(employeeLeaveRequest.getDuration());
        employeeLeave.setReportingManager(employeeLeaveRequest.getReportingManager());
        EmployeePersonal employee = personalRepo.findById(employeeId).orElseThrow(() -> new EntityNotFoundException("Employee not found"));
        employeeLeave.setEmployeePersonal(employee);
        return employeeLeave;
    }
public EmployeeLeaveResponse toEmployeeLeaveResponse(EmployeeLeave employeeLeave) {
        return EmployeeLeaveResponse.builder()
                .leaveStatus(employeeLeave.getLeaveStatus())
                .date(employeeLeave.getDate())
                .days(employeeLeave.getDays())
                .duration(employeeLeave.getDuration())
                .reportingManager(employeeLeave.getReportingManager())
                .leaveId(employeeLeave.getId())
                .created(employeeLeave.getCreated())
                .build();
}
}
