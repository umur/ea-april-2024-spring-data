package com.brianmugalu.demo.repository.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import jakarta.persistence.Id;
@Entity
@Data
public class Address {
    @Id
    private Long id;
    private String street;
    private String zip;
    private String city;
    @OneToOne
    @JoinColumn(name="id_user")
    @JsonIgnore
    private User user;
}
