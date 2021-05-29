package hrmsproject.business.concretes;

import hrmsproject.business.abstracts.JobSeekerService;
import hrmsproject.business.constants.Message;
import hrmsproject.core.utilities.results.DataResult;
import hrmsproject.core.utilities.results.SuccessDataResult;
import hrmsproject.dataAccess.abstracts.JobSeekerDao;
import hrmsproject.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {
    private final JobSeekerDao jobSeekerDao;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao) {
        super();
        this.jobSeekerDao = jobSeekerDao;
    }

    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<>(this.jobSeekerDao.findAll(), Message.AllJobSeekerListed);
    }

    @Override
    public DataResult<JobSeeker> findJobSeekerByFirstName(String seekerFirstName) {
        return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.findJobSeekerByFirstName(seekerFirstName),Message.FindJobSeekerFirstNameSuccess);
    }

    @Override
    public DataResult<JobSeeker> findJobSeekerByLastName(String seekerLastName) {
        return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.findJobSeekerByLastName(seekerLastName),Message.FindJobSeekerLastNameSuccess);
    }

    @Override
    public DataResult<JobSeeker> findJobSeekerDateOfBirth(LocalDate dateOfBirth) {
        return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.findJobSeekerByDateOfBirth(dateOfBirth),Message.FindDateOfBirthSuccess);
    }

    @Override
    public DataResult<JobSeeker> findJobSeekerByNationalId(String nationalId) {
        return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.findJobSeekerByNationalId(nationalId),Message.FindNationalIdSuccess);
    }
}
