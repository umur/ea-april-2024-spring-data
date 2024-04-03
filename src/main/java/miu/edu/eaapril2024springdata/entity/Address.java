package miu.edu.eaapril2024springdata.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Address {

    @Id
    private Long id;
    private String street;
    private String zip;
    private String city;

    @OneToOne
    private User user;
}
