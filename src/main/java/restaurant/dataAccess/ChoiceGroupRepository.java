package restaurant.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurant.entities.ChoiceGroup;

@Repository
public interface ChoiceGroupRepository extends JpaRepository<ChoiceGroup, Long> {
}
