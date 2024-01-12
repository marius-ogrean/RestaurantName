package restaurant.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OptionDto implements Serializable {
    private static final long serialVersionUID = 4084289409273744397L;

    private Long id;
    private String name;
    private BigDecimal price;
}
