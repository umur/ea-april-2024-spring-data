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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double price;
    private String rating;
    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;
    @OneToMany
    @JsonIgnore
    @JoinColumn(name = "reviews")
    List<Review> reviews;

}
