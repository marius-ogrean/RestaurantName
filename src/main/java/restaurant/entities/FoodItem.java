package restaurant.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "FOODITEMS")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodItem {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column
    private BigDecimal price;

    @ManyToOne
    private Category category;

    @ManyToMany
    @JoinTable(
            name = "FOODITEMCHOICEGROUPS",
            joinColumns = @JoinColumn(name = "foodItem_id"),
            inverseJoinColumns = @JoinColumn(name = "choiceGroup_id"))
    private Set<ChoiceGroup> choiceGroups;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<ChoiceGroup> getChoiceGroups() {
        return choiceGroups;
    }

    public void setChoiceGroups(Set<ChoiceGroup> choiceGroups) {
        this.choiceGroups = choiceGroups;
    }
}
