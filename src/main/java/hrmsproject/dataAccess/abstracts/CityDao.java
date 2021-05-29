package hrmsproject.dataAccess.abstracts;

import hrmsproject.entities.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<City, Integer> {
}
