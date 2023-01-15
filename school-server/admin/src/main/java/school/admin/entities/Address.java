package school.admin.entities;

import jakarta.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE)
    private Long id;
    private String city;
    private String state;
    private int pinCode;
    @OneToOne(mappedBy = "address")
    private SystemUserDetails userDetails;

    public Address() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public SystemUserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(SystemUserDetails userDetails) {
        this.userDetails = userDetails;
    }
}
