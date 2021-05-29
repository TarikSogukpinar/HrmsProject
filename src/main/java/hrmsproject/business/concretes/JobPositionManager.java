package hrmsproject.business.concretes;

import hrmsproject.business.abstracts.JobPositionService;
import hrmsproject.business.constants.Message;
import hrmsproject.core.utilities.results.DataResult;
import hrmsproject.core.utilities.results.Result;
import hrmsproject.core.utilities.results.SuccessDataResult;
import hrmsproject.core.utilities.results.SuccessResult;
import hrmsproject.dataAccess.abstracts.JobPositionDao;
import hrmsproject.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {


    private final JobPositionDao positionDao;

    @Autowired
    public JobPositionManager(JobPositionDao positionDao) {
        super();
        this.positionDao = positionDao;
    }


    @Override
    public DataResult<List<JobPosition>> getAll() {

        return new SuccessDataResult<List<JobPosition>>(this.positionDao.findAll(), Message.DataListed);
    }

    @Override
    public Result add(JobPosition jobPosition) {
        this.positionDao.save(jobPosition);
        return new SuccessResult(Message.JobPositionAdded);
    }

    @Override
    public DataResult<JobPosition> findByJobTitle(String title) {
        return new SuccessDataResult<JobPosition>(this.positionDao.findByJobTitle(title), Message.FindJobTitleSuccess);
    }

    @Override
    public DataResult<JobPosition> findByCreatedDate(LocalDate createDate) {
        return new SuccessDataResult<JobPosition>(this.positionDao.findByCreatedDate(createDate), Message.FindCreateDateSuccess);
    }


}
