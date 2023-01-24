package school.admin.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Setter
@Getter
@Entity
@DynamicUpdate
@NoArgsConstructor
public class SystemUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
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

    @OneToOne(cascade = {CascadeType.ALL, CascadeType.MERGE})
    @JoinColumn(name = "address_id", referencedColumnName = "id", updatable = true, insertable = true)
    private Address address;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_department",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "dept_id")
    )
    private Set<Department> department;

    public SystemUser(String username, String password) {
        this.username = username;
        this.password = password;
        this.isAccountNonExpired = true;
        this.isAccountNonLocked = true;
        this.isEnabled = true;
    }

    public static SystemUserBuilder getSystemUserBuilder(){
        return new SystemUserBuilder(new SystemUser());
    }

    @Override
    public String toString() {
        return "SystemUser{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isAccountNonExpired=" + isAccountNonExpired +
                ", isAccountNonLocked=" + isAccountNonLocked +
                ", isEnabled=" + isEnabled +
                ", roles=" + roles +
                ", address=" + address +
                ", department=" + department +
                '}';
    }
}
