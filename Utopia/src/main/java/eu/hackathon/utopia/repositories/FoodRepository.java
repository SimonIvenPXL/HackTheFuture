package eu.hackathon.utopia.repositories;

import eu.hackathon.utopia.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
