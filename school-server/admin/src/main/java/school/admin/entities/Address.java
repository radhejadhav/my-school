package school.admin.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE)
    private Long id;
    private String city;
    private String state;
    private int pinCode;
    @OneToOne(mappedBy = "address")
    @JsonBackReference
    private SystemUser userDetails;
}
