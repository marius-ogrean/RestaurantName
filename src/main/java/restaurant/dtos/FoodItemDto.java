package restaurant.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodItemDto implements Serializable {
    private static final long serialVersionUID = 7337928943187210066L;

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Long categoryId;
    private List<ChoiceGroupDto> groups;
}
