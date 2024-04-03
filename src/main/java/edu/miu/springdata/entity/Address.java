package edu.miu.springdata.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Address {
    @Id
    private long id;
    private String street;
    private int zip;
    private String City;
}
