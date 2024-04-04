package miu.ea.springdata.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Review {

//    Review with id, comment.
//    A Review can only belong to one User and Product.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String comment;

    @ManyToOne
    Product product;

    @ManyToOne
    User user;

}
