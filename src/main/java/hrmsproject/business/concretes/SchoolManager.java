package hrmsproject.business.concretes;


import hrmsproject.business.abstracts.SchoolService;
import hrmsproject.business.constants.Message;
import hrmsproject.core.utilities.results.DataResult;
import hrmsproject.core.utilities.results.Result;
import hrmsproject.core.utilities.results.SuccessDataResult;
import hrmsproject.core.utilities.results.SuccessResult;
import hrmsproject.dataAccess.abstracts.SchoolDao;
import hrmsproject.entities.concretes.School;
import net.bytebuddy.TypeCache;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolManager implements SchoolService {
    private final SchoolDao schoolDao;

    public SchoolManager(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }

    @Override
    public DataResult<List<School>> getAll() {
        Sort sort = Sort.by(Sort.Direction.DESC, "finishDate");
        return new SuccessDataResult<>(this.schoolDao.findAll(), Message.AllEmployerListed);
    }

    @Override
    public Result add(School school) {
        this.schoolDao.save(school);
        return new SuccessResult("");
    }
}
