package hrmsproject.dataAccess.abstracts;

import hrmsproject.entities.concretes.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionDao extends JpaRepository<Position, Integer> {
}
