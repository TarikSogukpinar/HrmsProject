package hrmsproject.business.concretes;


import hrmsproject.business.abstracts.ForeignLanguageService;
import hrmsproject.business.constants.Message;
import hrmsproject.core.utilities.results.DataResult;
import hrmsproject.core.utilities.results.Result;
import hrmsproject.core.utilities.results.SuccessDataResult;
import hrmsproject.core.utilities.results.SuccessResult;
import hrmsproject.dataAccess.abstracts.ForeignLanguageDao;
import hrmsproject.entities.concretes.ForeignLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForeignLanguageManager implements ForeignLanguageService {
    private final ForeignLanguageDao foreignLanguageDao;

    @Autowired
    public ForeignLanguageManager(ForeignLanguageDao foreignLanguageDao) {
        this.foreignLanguageDao = foreignLanguageDao;
    }

    @Override
    public DataResult<List<ForeignLanguage>> getAll() {
        return new SuccessDataResult<>(this.foreignLanguageDao.findAll(), Message.AllEmployerListed);
    }

    @Override
    public Result add(ForeignLanguage foreignLanguage) {
        this.foreignLanguageDao.save(foreignLanguage);
        return new SuccessResult("");
    }
}
