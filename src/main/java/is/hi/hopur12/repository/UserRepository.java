package is.hi.hopur12.repository;

import is.hi.hopur12.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/*
 * Repository fyrir User klasa.
 * Talar við Service klasa.
 */

public interface UserRepository extends JpaRepository<User, Long> {
	
	/*
	 * Vistar gögn í gagnagrunn
	 * Tekur User object og vistar í gagnagrunns töflu.
	 */
	User save(User user);
	
	List<User> findAll();
	
	List<User> findByName(String name);
}
