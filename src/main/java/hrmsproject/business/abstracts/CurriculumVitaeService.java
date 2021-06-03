package hrmsproject.business.abstracts;

import hrmsproject.core.utilities.results.DataResult;
import hrmsproject.core.utilities.results.Result;
import hrmsproject.entities.concretes.CurriculumVitae;

import java.util.List;

public interface CurriculumVitaeService {
    DataResult<List<CurriculumVitae>> getAll();

    Result add(CurriculumVitae curriculumVitae);
}
