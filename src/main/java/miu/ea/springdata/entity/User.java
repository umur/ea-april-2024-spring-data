package miu.ea.springdata.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
public class User {

//    User with id, email, password, firstName, lastname.
//    User can create many Reviews.
//    User can have only one Address.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String firstName;

    private String lastName;

    private String password;


    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Review> reviewList;


}
