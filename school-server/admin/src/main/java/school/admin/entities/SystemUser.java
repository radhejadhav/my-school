package school.admin.entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class SystemUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long ID;
    @Column(name = "email")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "is_account_non_expired")
    private boolean isAccountNonExpired;
    @Column(name = "is_account_non_locked")
    private boolean isAccountNonLocked;
    @Column(name = "is_enabled")
    private boolean isEnabled;
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> roles;

    public SystemUser() {
        this.isAccountNonExpired = true;
        this.isAccountNonLocked = true;
        this.isEnabled = true;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public Long getID() {
        return ID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public Set<String> getRoles() {
        return roles;
    }

    @Override
    public String toString() {
        return "SystemUser{" +
                "ID=" + ID +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isAccountNonExpired=" + isAccountNonExpired +
                ", isAccountNonLocked=" + isAccountNonLocked +
                ", isEnabled=" + isEnabled +
                ", roles=" + roles +
                '}';
    }
}
