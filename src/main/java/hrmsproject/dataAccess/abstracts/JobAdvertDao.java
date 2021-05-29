package hrmsproject.dataAccess.abstracts;

import hrmsproject.entities.concretes.JobAdvert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {
    JobAdvert findByEmployerId(int id);

    JobAdvert findBySalaryMax(int maxSalary);

    JobAdvert findBySalaryMin(int minSalary);

    @Query("From JobAdvert where isOpen = true")
    List<JobAdvert> getAllOpenJobAdvertList();

    @Query("From JobAdvert where isOpen = false")
    List<JobAdvert> getAllCloseJobAdvertList();


    @Query("From JobAdvert where isOpen = true Order By publishedAt ASC")
    List<JobAdvert> findAllByOrderByPublishedAtDesc();


}
