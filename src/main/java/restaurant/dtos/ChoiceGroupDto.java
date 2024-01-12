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
public class ChoiceGroupDto implements Serializable {
    private static final long serialVersionUID = -6477048972091076589L;

    private Long id;
    private String name;
    private Boolean required;
    private List<OptionDto> options;
}
