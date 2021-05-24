package hrmsproject.business.concretes;

import hrmsproject.business.abstracts.EmployeeService;
import hrmsproject.business.constants.Message;
import hrmsproject.core.utilities.businessrules.BusinessRules;
import hrmsproject.core.utilities.results.*;
import hrmsproject.dataAccess.abstracts.EmployeeDao;
import hrmsproject.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeManager implements EmployeeService {
    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeManager(EmployeeDao employeeDao) {
        super();
        this.employeeDao = employeeDao;
    }


    @Override
    public DataResult<List<Employee>> getAll() {
        return new SuccessDataResult<>(this.employeeDao.findAll(), Message.AllEmployeeListed);
    }

    @Override
    public Result add(Employee employee) {
        var result = BusinessRules.RunBusinessRules();
        if (result != null) {
            return result;
        }
        this.employeeDao.save(employee);
        return new SuccessResult(Message.RegisterSuccess);
    }

    @Override
    public Result delete(Employee employee) {
        this.employeeDao.delete(employee);
        return new SuccessResult(Message.DeleteSuccess);
    }

    @Override
    public Result update(Employee employee) {
        this.employeeDao.save(employee);
        return new SuccessResult(Message.UpdateSuccess);
    }

}
