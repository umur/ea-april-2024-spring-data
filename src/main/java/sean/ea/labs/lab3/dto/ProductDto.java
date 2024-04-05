package sean.ea.labs.lab3.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private String name;
    private BigDecimal price;
    private BigDecimal rating;
    private String categoryName;
}
