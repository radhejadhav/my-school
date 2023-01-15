package school.admin.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "department")
    private Set<SystemUserDetails> userDetails;

    public Department() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<SystemUserDetails> getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(Set<SystemUserDetails> userDetails) {
        this.userDetails = userDetails;
    }
}
