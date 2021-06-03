package hrmsproject.business.abstracts;

import hrmsproject.core.utilities.results.DataResult;
import hrmsproject.core.utilities.results.Result;
import hrmsproject.entities.concretes.JobPosition;
import hrmsproject.entities.concretes.JobSeeker;

import java.time.LocalDate;
import java.util.List;

public interface JobSeekerService {
    DataResult<List<JobSeeker>> getAll();

    Result add(JobSeeker jobSeeker);

    DataResult<JobSeeker> findJobSeekerByFirstName(String seekerFirstName);

    DataResult<JobSeeker> findJobSeekerByLastName(String seekerLastName);

    DataResult<JobSeeker> findJobSeekerDateOfBirth(LocalDate dateOfBirth);

    DataResult<JobSeeker> findJobSeekerByNationalId(String nationalId);
}
