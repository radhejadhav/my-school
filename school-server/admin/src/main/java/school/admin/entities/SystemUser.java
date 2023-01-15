package school.admin.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class SystemUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "email")
    private String username;
    @Column(name = "password")
    @JsonIgnore
    private String password;
    @Column(name = "is_account_non_expired")
    private boolean isAccountNonExpired;
    @Column(name = "is_account_non_locked")
    private boolean isAccountNonLocked;
    @Column(name = "is_enabled")
    private boolean isEnabled;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_details_map",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "details_id", referencedColumnName = "id")
    )
    private SystemUserDetails userDetails;

    public SystemUser() {
    }

    public SystemUser(SystemUserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public SystemUser(String username, String Password) {
        this.username = username;
        this.password = Password;
        this.isAccountNonExpired = true;
        this.isAccountNonLocked = true;
        this.isEnabled = true;
    }

    public SystemUserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(SystemUserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public void setID(Long id) {
        this.id = id;
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

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
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

    public Set<Role> getRoles() {
        return roles;
    }

    @Override
    public String toString() {
        return "SystemUser{" +
                "ID=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isAccountNonExpired=" + isAccountNonExpired +
                ", isAccountNonLocked=" + isAccountNonLocked +
                ", isEnabled=" + isEnabled +
                ", roles=" + roles +
                '}';
    }
}
