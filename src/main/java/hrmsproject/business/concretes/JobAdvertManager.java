package hrmsproject.business.concretes;

import hrmsproject.business.abstracts.JobAdvertService;
import hrmsproject.business.constants.Message;
import hrmsproject.core.utilities.businessrules.BusinessRules;
import hrmsproject.core.utilities.results.*;
import hrmsproject.dataAccess.abstracts.JobAdvertDao;
import hrmsproject.entities.concretes.JobAdvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertManager implements JobAdvertService {

    private final JobAdvertDao jobAdvertDao;

    @Autowired
    public JobAdvertManager(JobAdvertDao jobAdvertDao) {
        super();
        this.jobAdvertDao = jobAdvertDao;
    }

    @Override
    public Result add(JobAdvert jobAdvert) {
        var result = BusinessRules.RunBusinessRules();
        if (result != null) {
            return result;
        }
        this.jobAdvertDao.save(jobAdvert);
        return new SuccessResult(Message.JobAdvertAdded);
    }

    @Override
    public Result update(JobAdvert jobAdvert) {
        this.jobAdvertDao.save(jobAdvert);
        return new SuccessResult(Message.UpdateSuccess);
    }

    @Override
    public Result delete(int id) {
        this.jobAdvertDao.deleteById(id);
        return new SuccessResult(Message.JobAdvertDeleted);
    }

    @Override
    public Result changeOpenToClose(int id) {

        var result = BusinessRules.RunBusinessRules(checkById(id), checkByIdOpen(id));
        if (result != null) {
            return result;
        }


        JobAdvert jobAdvert = getById(id).getData();
        jobAdvert.setOpen(false);
        update(jobAdvert);
        return new SuccessResult(Message.JobAdvertSuccessfullyClosed);
    }

    private Result checkById(int id) {
        if (getById(id) == null) {
            return new ErrorResult(Message.JobAdvertNone);

        }
        return new SuccessResult(Message.AllJobAdvertListed);
    }

    private Result checkByIdOpen(int id) {
        if (!getById(id).getData().isOpen()) {
            return new ErrorResult(Message.JobAdvertClosed);
        }
        return new SuccessResult(Message.DataListed);
    }

    @Override
    public DataResult<List<JobAdvert>> getAll() {
        return new SuccessDataResult<>(this.jobAdvertDao.findAll(), Message.AllJobSeekerListed);
    }

    @Override
    public DataResult<JobAdvert> getById(int id) {
        return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.getOne(id));
    }

    @Override
    public DataResult<JobAdvert> findBySalaryMax(int maxSalary) {
        return new SuccessDataResult<>(this.jobAdvertDao.findBySalaryMax(maxSalary), Message.SalaryMaxListed);
    }

    @Override
    public DataResult<JobAdvert> findBySalaryMin(int minSalary) {
        return new SuccessDataResult<>(this.jobAdvertDao.findBySalaryMin(minSalary), Message.SalaryMinListed);
    }


    @Override
    public DataResult<List<JobAdvert>> getAllOpenJobAdvertList() {
        return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getAllOpenJobAdvertList());
    }

    @Override
    public DataResult<List<JobAdvert>> getAllCloseJobAdvertList() {
        return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getAllCloseJobAdvertList());
    }

    @Override
    public DataResult<List<JobAdvert>> findAllByOrderByPublishedAt() {
        return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAllByOrderByPublishedAtDesc());
    }


    @Override
    public DataResult<JobAdvert> findByEmployerId(int id) {
        return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.findByEmployerId(id));
    }

}