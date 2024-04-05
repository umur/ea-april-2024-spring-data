package springData.example.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String comment;
   @ManyToOne
   @JoinColumn(name = "product_id")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
