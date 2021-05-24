package hrmsproject.dataAccess.abstracts;

import hrmsproject.core.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
}
