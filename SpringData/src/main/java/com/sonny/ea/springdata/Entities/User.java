package com.sonny.ea.springdata.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class User {
    @Id
    private Long id;
    private String password;
    private String email;
    private String firstName;
    private String lastName;

    @JoinColumn(name = "user_id")
    @OneToMany
    private List<Review> reviews;

    @JoinColumn(name = "address_id")
    @OneToOne
    private Address address;
}
