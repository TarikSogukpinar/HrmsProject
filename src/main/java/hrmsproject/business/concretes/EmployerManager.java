package hrmsproject.business.concretes;

import hrmsproject.business.abstracts.EmployerService;
import hrmsproject.business.constants.Message;
import hrmsproject.core.utilities.businessrules.BusinessRules;
import hrmsproject.core.utilities.results.*;
import hrmsproject.dataAccess.abstracts.EmployerDao;
import hrmsproject.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {
    private final EmployerDao employerDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao) {
        super();
        this.employerDao = employerDao;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<>(this.employerDao.findAll(), Message.AllEmployerListed);
    }

    @Override
    public Result add(Employer employer) {
        var result = BusinessRules.RunBusinessRules(employerWebSiteIfAlreadyExists(employer),employerPhoneNumberIfAlreadyExists(employer));
        if (result != null) {
            return result;
        }
        this.employerDao.save(employer);
        return new SuccessResult(Message.EmployerAdded);
    }

    @Override
    public Result delete(Employer employer) {
        this.employerDao.delete(employer);
        return new SuccessResult(Message.DeleteSuccess);
    }

    @Override
    public Result update(Employer employer) {
        this.employerDao.save(employer);
        return new SuccessResult(Message.UpdateSuccess);
    }

    private Result employerWebSiteIfAlreadyExists(Employer employer){
        for (Employer employers:employerDao.findAll()) {
            if (employer.getWebSite().equals(employers.getWebSite())){
                return new ErrorResult(Message.ThisWebSiteAddressIsAlreadyInTheSystem);
            }

        }
        return new SuccessResult(Message.RegisterSuccess);
    }
    private Result employerPhoneNumberIfAlreadyExists(Employer employer){
        for (Employer employers:employerDao.findAll()) {
            if (employer.getPhoneNumber().equals(employers.getPhoneNumber())){
                return new ErrorResult(Message.ThisPhoneNumberIsAlreadyInTheSystem);
            }

        }
        return new SuccessResult(Message.RegisterSuccess);
    }
}
