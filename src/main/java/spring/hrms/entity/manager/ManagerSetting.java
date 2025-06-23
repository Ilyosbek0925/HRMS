package spring.hrms.entity.manager;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import spring.hrms.entity.BaseEntity;

@Getter
@Setter
@Entity
public class ManagerSetting extends BaseEntity {
    private String appearance="Light";
    private String language="English";
    private boolean twoFactorAuth=true;
    private boolean mobilePushNotifications=true;
    private boolean desktopNotifications=true;
    private boolean emailNotifications=true;
    @OneToOne
    private Manager manager;
}
