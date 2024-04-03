package com.sonny.ea.springdata.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Address {
    @Id
    private Long id;

    private String zip;
    private String city;
    private String street;
}
