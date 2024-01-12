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
public class MenuDto implements Serializable {
    private static final long serialVersionUID = 1416946157918349600L;

    private Long id;
    private String currency;
    private List<CategoryDto> categories;
}
