package hrmsproject.business.concretes;

import hrmsproject.business.abstracts.CurriculumVitaeService;
import hrmsproject.core.utilities.results.DataResult;
import hrmsproject.core.utilities.results.Result;
import hrmsproject.core.utilities.results.SuccessDataResult;
import hrmsproject.core.utilities.results.SuccessResult;
import hrmsproject.dataAccess.abstracts.CurriculumVitaeDao;
import hrmsproject.entities.concretes.CurriculumVitae;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService {
    private final CurriculumVitaeDao curriculumVitaeDao;

    @Autowired
    public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao) {
        super();
        this.curriculumVitaeDao = curriculumVitaeDao;
    }

    @Override
    public DataResult<List<CurriculumVitae>> getAll() {
        return new SuccessDataResult<>(this.curriculumVitaeDao.findAll(), "All CV GET");
    }

    @Override
    public Result add(CurriculumVitae curriculumVitae) {
        this.curriculumVitaeDao.save(curriculumVitae);
        return new SuccessResult("");
    }


}
