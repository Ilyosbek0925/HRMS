package spring.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.hrms.entity.manager.ManagerSetting;

public interface SettingRepository extends JpaRepository<ManagerSetting,Integer> {



}
