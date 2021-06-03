package hrmsproject.business.abstracts;

import hrmsproject.core.utilities.results.DataResult;
import hrmsproject.core.utilities.results.Result;
import hrmsproject.entities.concretes.JobExperience;
import hrmsproject.entities.concretes.School;

import java.util.List;

public interface SchoolService {
    DataResult<List<School>> getAll();

    Result add(School school);
}
