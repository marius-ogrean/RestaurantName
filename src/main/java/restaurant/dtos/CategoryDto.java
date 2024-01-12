package restaurant.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto implements Serializable {
    private static final long serialVersionUID = -1109419069837528434L;

    private Long id;
    private String name;
    private String description;
    private List<FoodItemDto> items;
    private List<ChoiceGroupDto> groups;
}
