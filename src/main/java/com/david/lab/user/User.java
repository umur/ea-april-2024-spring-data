package com.david.lab.user;

import com.david.lab.address.Address;
import com.david.lab.review.Review;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @JsonManagedReference
    @OneToMany(mappedBy = "submittedUser")
    private List<Review> submittedReviews;

    @JsonBackReference
    @ManyToOne
    private Address address;
}
