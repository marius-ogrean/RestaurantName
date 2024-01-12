package restaurant.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurant.entities.Option;

@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {
}
