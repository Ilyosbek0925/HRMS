package spring.hrms.repository.managerRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.hrms.entity.manager.ManagerSetting;

@Repository
public interface ManagerSettingRepo extends JpaRepository<ManagerSetting, Integer> {
}
