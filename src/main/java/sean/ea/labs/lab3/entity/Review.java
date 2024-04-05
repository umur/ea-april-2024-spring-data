package sean.ea.labs.lab3.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;

    @JoinColumn(name = "id_product")
    @ManyToOne
    @JsonBackReference(value = "product-review")    // have to add value when there are more than 1 BackRef
    private Product product;

    @JoinColumn(name = "id_user")
    @ManyToOne
    @JsonBackReference(value = "user-review")
    private User user;

}
