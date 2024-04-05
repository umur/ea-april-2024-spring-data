package com.brianmugalu.demo.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class User {
    @Id
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "userR", cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<Review>reviewList;

    @OneToOne(mappedBy = "user",cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private Address address;

    public void addReview (Review review){
        reviewList.add(review);
    }
}
