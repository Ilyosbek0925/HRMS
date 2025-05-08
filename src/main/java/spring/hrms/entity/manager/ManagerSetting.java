package spring.hrms.entity.manager;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.hrms.entity.BaseEntity;
import spring.hrms.entity.Manager;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ManagerSetting extends BaseEntity {
private String screenMode;
private String language;
private String twoFactorAuthentification;
private String mobileNotification;
private String DesktopNotification;
private String emailNotification;
@OneToOne
private Manager manager;


}
