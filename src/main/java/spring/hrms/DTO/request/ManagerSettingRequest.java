package spring.hrms.DTO.request;

import lombok.Value;
import spring.hrms.entity.manager.ManagerSetting;

import java.io.Serializable;

/**
 * DTO for {@link ManagerSetting}
 */
@Value
public class ManagerSettingRequest implements Serializable {
    String appearance;
    String language;
    boolean twoFactorAuth;
    boolean mobilePushNotifications;
    boolean desktopNotifications;
    boolean emailNotifications;
    Integer managerId;
}