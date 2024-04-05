package springData.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    @OneToMany()
    @JsonIgnore
    @JoinColumn(name = "reviews")
    private List<Review> reviews;
    @OneToOne
    @JoinColumn(name = "address")
    @JsonIgnore
    private Address address;
}


