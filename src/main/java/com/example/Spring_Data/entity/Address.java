package com.example.Spring_Data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String city;
    private String state;
    private String country;
    private String zip;
    private String street;
    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    private User user;
}
