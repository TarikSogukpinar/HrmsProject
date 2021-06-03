package hrmsproject.dataAccess.abstracts;

import hrmsproject.entities.concretes.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolDao extends JpaRepository<School, Integer> {
}
