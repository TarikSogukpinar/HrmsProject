package hrmsproject.business.abstracts;

import hrmsproject.core.utilities.results.DataResult;
import hrmsproject.core.utilities.results.Result;
import hrmsproject.entities.concretes.JobExperience;

import java.util.List;

public interface JobExperienceService {
    DataResult<List<JobExperience>> getAll();

    Result add(JobExperience jobExperience);
}
