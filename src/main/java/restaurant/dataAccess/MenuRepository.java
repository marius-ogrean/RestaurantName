package restaurant.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurant.entities.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
