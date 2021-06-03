package hrmsproject.dataAccess.abstracts;

import hrmsproject.entities.concretes.CurriculumVitae;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurriculumVitaeDao extends JpaRepository<CurriculumVitae, Integer> {
}
