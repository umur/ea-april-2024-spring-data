package com.example.labData.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address {
    @Id
    private long id;
    private String city;
    private String street;
    private String zip;

    @OneToOne
    private User user;
}
