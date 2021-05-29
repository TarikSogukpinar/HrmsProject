package hrmsproject.dataAccess.abstracts;

import hrmsproject.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {
    JobSeeker findJobSeekerByFirstName(String firstName);

    JobSeeker findJobSeekerByLastName(String lastName);

    JobSeeker findJobSeekerByNationalId(String nationalId);

    JobSeeker findJobSeekerByDateOfBirth(LocalDate dateOfBirth);
}
