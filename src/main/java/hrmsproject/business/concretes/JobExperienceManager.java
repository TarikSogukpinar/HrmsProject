package hrmsproject.business.concretes;


import hrmsproject.business.abstracts.JobExperienceService;
import hrmsproject.business.constants.Message;
import hrmsproject.core.utilities.results.DataResult;
import hrmsproject.core.utilities.results.Result;
import hrmsproject.core.utilities.results.SuccessDataResult;
import hrmsproject.core.utilities.results.SuccessResult;
import hrmsproject.dataAccess.abstracts.JobExperienceDao;
import hrmsproject.entities.concretes.JobExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobExperienceManager implements JobExperienceService {
    private final JobExperienceDao jobExperienceDao;

    @Autowired
    public JobExperienceManager(JobExperienceDao jobExperienceDao) {
        this.jobExperienceDao = jobExperienceDao;
    }

    @Override
    public DataResult<List<JobExperience>> getAll() {
        return new SuccessDataResult<>(this.jobExperienceDao.findAll(), Message.AllEmployerListed);
    }

    @Override
    public Result add(JobExperience jobExperience) {
        this.jobExperienceDao.save(jobExperience);
        return new SuccessResult("");
    }
}
