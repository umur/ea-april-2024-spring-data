package com.miu.SpringData.user;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.miu.SpringData.address.Address;
import com.miu.SpringData.category.Category;
import com.miu.SpringData.review.Review;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @JsonBackReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> reviews;

}
