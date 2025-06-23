package spring.hrms.DTO.response;

import lombok.Builder;
import lombok.Value;
import spring.hrms.entity.manager.ManagerSetting;

import java.io.Serializable;

/**
 * DTO for {@link ManagerSetting}
 */
@Value
@Builder
public class ManagerSettingResponse implements Serializable {
    Integer id;
    String appearance;
    String language;
    boolean twoFactorAuth;
    boolean mobilePushNotifications;
    boolean desktopNotifications;
    boolean emailNotifications;
    Integer managerId;
}