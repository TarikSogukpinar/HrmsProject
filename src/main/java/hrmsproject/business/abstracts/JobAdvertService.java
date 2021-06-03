package hrmsproject.business.abstracts;

import hrmsproject.core.utilities.results.DataResult;
import hrmsproject.core.utilities.results.Result;
import hrmsproject.entities.concretes.JobAdvert;

import java.util.List;

public interface JobAdvertService {
    Result add(JobAdvert jobAdvert);

    Result update(JobAdvert jobAdvert);

    Result delete(int id);

    Result changeOpenToClose(int id);

    DataResult<JobAdvert> getById(int id);

    DataResult<JobAdvert> findBySalaryMax(int maxSalary);

    DataResult<JobAdvert> findBySalaryMin(int minSalary);

    DataResult<JobAdvert> findByEmployerId(int id);

    DataResult<List<JobAdvert>> getAll();

    DataResult<List<JobAdvert>> getAllOpenJobAdvertList();

    DataResult<List<JobAdvert>> getAllCloseJobAdvertList();

    DataResult<List<JobAdvert>> findAllByOrderByPublishedAt();
}
