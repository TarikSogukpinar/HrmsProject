package hrmsproject.dataAccess.abstracts;

import hrmsproject.entities.concretes.ForeignLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForeignLanguageDao extends JpaRepository<ForeignLanguage, Integer> {
}
