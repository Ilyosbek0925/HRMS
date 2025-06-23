package spring.hrms.service.employeeService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import spring.hrms.DTO.projection.AttendanceProjection;
import spring.hrms.DTO.request.AttendanceRequest;
import spring.hrms.DTO.request.AttendanceUpdateRequest;
import spring.hrms.DTO.response.AttendanceResponse;
import spring.hrms.entity.employee.EmployeePersonal;
import spring.hrms.entity.employee.EmployeeProfessional;
import spring.hrms.entity.employee.document.EmployeePhoto;
import spring.hrms.exception.UserNotFoundException;
import spring.hrms.repository.AttendanceRepo;
import spring.hrms.entity.employee.Attendance;
import spring.hrms.mapper.AttendanceMapper;
import spring.hrms.repository.employeeRepo.EmployeePersonalRepo;
import spring.hrms.spesification.AttendanceSpecification;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceService {
    private final AttendanceRepo repo;
    private final AttendanceMapper mapper;
    private final EmployeePersonalRepo personalRepo;

    public AttendanceResponse add(int employeeId, AttendanceRequest attendanceRequest) {
        Attendance save = repo.save(mapper.toAttendance(employeeId, attendanceRequest));
        return mapper.toAttendanceResponse(save);
    }


    public List<AttendanceResponse> getAllAttendanceByEmployeeId(int employeeId) {
        List<Attendance> attendances = personalRepo.findById(employeeId).orElseThrow(() -> new UserNotFoundException("Employee not found with id "+employeeId)).getAttendances();
        return mapper.toAttendanceResponse(attendances);
    }

    public void update(List<AttendanceUpdateRequest> attendanceUpdateRequests) {
        List<Attendance> attendances = mapper.toAttendanceList(attendanceUpdateRequests);
        repo.saveAll(attendances);
    }

    public Page<AttendanceProjection> getAttendance(int page, int size) {
        Pageable pageRequest = PageRequest.of(page, size);
        return repo.getAttendanceProjections(pageRequest);
    }

    public List<AttendanceProjection> filter(String name, LocalDate minDate, LocalDate maxDate, LocalTime minTime, LocalTime maxTime, String status) {
        Specification<Attendance> specification = Specification.where(AttendanceSpecification.hasStatus(status)).and(AttendanceSpecification.hasDate(minDate, maxDate))
                .and(AttendanceSpecification.hasTime(minTime, maxTime)).and(AttendanceSpecification.hasFirstSecond(name));


        List<Attendance> all = repo.findAll(specification, Sort.by("date").descending());
        return all.stream().map(att -> {
            EmployeePersonal employeePersonal = att.getEmployeePersonal();
            EmployeePhoto employeePhoto = employeePersonal.getEmployeePhoto();
            EmployeeProfessional employeeProfessional = employeePersonal.getEmployeeProfessional();


            return new AttendanceProjection(
                    att.getId(),
                    employeePhoto.getDownloadUrl(),
                    employeePersonal.getFirstName(),
                    employeePersonal.getLastName(),
                    employeeProfessional.getDesignation(),
                    employeeProfessional.getEmployeeType(),
                    att.getBreakTime(),
                    att.getCheckOut(),
                    att.getCheckTime(),
                    att.getDate(),
                    att.getStatus(),
                    att.getCheckIn(),
                    att.getWorkingHours()
            );
        }).toList();


    }
}
