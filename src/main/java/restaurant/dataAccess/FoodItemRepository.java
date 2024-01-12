package restaurant.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurant.entities.FoodItem;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {
}
