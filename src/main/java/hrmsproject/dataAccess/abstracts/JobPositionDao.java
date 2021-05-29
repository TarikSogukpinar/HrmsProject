package hrmsproject.dataAccess.abstracts;

import hrmsproject.entities.concretes.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {
    JobPosition findByJobTitle(String title);

    JobPosition findByCreatedDate(LocalDate createDate);
}
