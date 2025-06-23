package spring.hrms.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import spring.hrms.entity.manager.Manager;
import spring.hrms.entity.manager.ManagerSetting;
import spring.hrms.repository.managerRepo.ManagerRepository;
import spring.hrms.repository.managerRepo.ManagerSettingRepo;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final ManagerSettingRepo settingsRepository;
    private final ManagerRepository managerRepository;
    private final PasswordEncoder passwordEncoder;
    @Value("${app.data.init}")
    private boolean applicationInit;



    @Override
    public void run(String... args) {
        if (applicationInit) {
            Manager manager = new Manager();
            manager.setEmail("xakimovilyosbek22@gmail.com");
            manager.setPassword(passwordEncoder.encode("admin"));
            manager.setName("admin");
            Manager save = managerRepository.save(manager);
            settingLoader(save.getId());
        }
    }

    public void settingLoader(Integer managerId) {
        ManagerSetting settings = new ManagerSetting();
        settings.setManager(managerRepository.findById(managerId).orElseThrow(() -> new RuntimeException("manager not found")));
        settings.setAppearance("LIGHT");
        settings.setLanguage("ENGLISH");
        settings.setTwoFactorAuth(true);
        settings.setMobilePushNotifications(true);
        settings.setDesktopNotifications(true);
        settings.setEmailNotifications(true);
        settingsRepository.save(settings);
    }


}
