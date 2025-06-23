package spring.hrms.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import spring.hrms.DTO.request.ManagerSettingRequest;
import spring.hrms.DTO.response.ManagerSettingResponse;
import spring.hrms.entity.manager.ManagerSetting;
import spring.hrms.entity.manager.Manager;
import spring.hrms.repository.managerRepo.ManagerRepository;

@Component
@RequiredArgsConstructor
public class ManagerSettingMapper {
    private final ManagerRepository managerRepo;

    public ManagerSettingResponse toManagerSettingResponse(ManagerSetting managerSetting) {
        return ManagerSettingResponse.builder()
                .id(managerSetting.getId())
                .managerId(managerSetting.getManager().getId())
                .emailNotifications(managerSetting.isEmailNotifications())
                .appearance(managerSetting.getAppearance())
                .mobilePushNotifications(managerSetting.isMobilePushNotifications())
                .desktopNotifications(managerSetting.isDesktopNotifications())
                .twoFactorAuth(managerSetting.isTwoFactorAuth())
                .language(managerSetting.getLanguage())
                .build();
    }


    public ManagerSetting toManagerSetting(Integer managerId, ManagerSettingRequest request) {
        Manager manager = managerRepo.findById(managerId).orElseThrow(() -> new RuntimeException("manager not found!"));
        ManagerSetting setting = new ManagerSetting();
        setting.setId(manager.getId());
        setting.setId(manager.getSetting().getId());
        setting.setAppearance(request.getAppearance());
        setting.setManager(manager);
        setting.setLanguage(request.getLanguage());
        setting.setMobilePushNotifications(request.isMobilePushNotifications());
        setting.setDesktopNotifications(request.isDesktopNotifications());
        setting.setTwoFactorAuth(request.isTwoFactorAuth());
        setting.setEmailNotifications(request.isEmailNotifications());
        return setting;

    }
}
