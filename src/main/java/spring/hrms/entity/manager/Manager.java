package spring.hrms.entity.manager;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import spring.hrms.entity.BaseEntity;

import java.util.Collection;

@Getter
@Setter
@Entity
public class Manager extends BaseEntity implements UserDetails {
    private String photoDownloadUrl;
    private String name;
    private String email;
    private String password;
    @OneToOne(mappedBy = "manager")
    private ManagerSetting setting;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
