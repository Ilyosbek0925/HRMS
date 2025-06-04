package spring.hrms.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.hrms.DTO.projection.AttendanceProjection;
import spring.hrms.entity.employee.Attendance;

import java.util.List;


@Repository
public interface AttendanceRepo extends JpaRepository<Attendance, Integer>, JpaSpecificationExecutor<Attendance> {
    @Query("select new spring.hrms.DTO.projection.AttendanceProjection(emp.id, pho.downloadUrl, " +
            "emp.firstName, emp.lastName, prof.designation, " +
            "prof.employeeType, att.breakTime, att.checkOut, att.checkTime, att.date, att.status, " +
            "att.checkIn, att.workingHours) " +
            "from EmployeePersonal emp " +
            "join emp.employeePhoto pho " +
            "join emp.attendances att " +
            "join emp.employeeProfessional prof " +
            "order by att.date desc")
    Page<AttendanceProjection> getAttendanceProjections(Pageable pageable);


    @Query("select new spring.hrms.DTO.projection.AttendanceProjection(emp.id, pho.downloadUrl, " +
            "emp.firstName, emp.lastName, prof.designation, " +
            "prof.employeeType, att.breakTime, att.checkOut, att.checkTime, att.date, att.status, " +
            "att.checkIn, att.workingHours) " +
            "from EmployeePersonal emp " +
            "join emp.employeePhoto pho " +
            "join emp.attendances att " +
            "join emp.employeeProfessional prof " +
            "order by att.date desc")
    List<AttendanceProjection> findAllBy(Specification<AttendanceProjection> spec);


}