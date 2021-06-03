package hrmsproject.business.abstracts;

import hrmsproject.core.utilities.results.DataResult;
import hrmsproject.core.utilities.results.Result;
import hrmsproject.entities.concretes.ForeignLanguage;

import java.util.List;

public interface ForeignLanguageService {
    DataResult<List<ForeignLanguage>> getAll();

    Result add(ForeignLanguage foreignLanguage);
}
