package is.hi.hopur12.repository;

import is.hi.hopur12.model.Food;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/*
 * Repository fyrir User klasa.
 * Talar við Service klasa.
 */
public interface FoodRepository extends JpaRepository<Food, Long> {
	
	/*
	 * Vistar gögn í gagnagrunn
	 * Tekur User object og vistar í gagnagrunns töflu.
	 */
	Food save(Food food);
	
	List<Food> findAll();
	
	List<Food> findByName(String name);
	
	List<Food> findAllByOrderByIdDesc();
	
	@Override
	Food findOne(Long id);
	
}
