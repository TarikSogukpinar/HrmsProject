package hrmsproject.business.abstracts;

import hrmsproject.core.utilities.results.DataResult;
import hrmsproject.core.utilities.results.Result;
import hrmsproject.entities.concretes.JobPosition;

import java.time.LocalDate;
import java.util.List;

public interface JobPositionService {
    DataResult<List<JobPosition>> getAll();

    Result add(JobPosition jobPosition);

    DataResult<JobPosition> findByJobTitle(String title);

    DataResult<JobPosition> findByCreatedDate(LocalDate createDate);

}
