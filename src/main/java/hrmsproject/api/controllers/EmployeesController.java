package hrmsproject.api.controllers;

import hrmsproject.business.abstracts.EmployeeService;
import hrmsproject.core.utilities.results.DataResult;
import hrmsproject.core.utilities.results.Result;
import hrmsproject.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeesController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/getallEmployee")
    public DataResult<List<Employee>> getAll() {
        return this.employeeService.getAll();
    }

    @PostMapping("/addEmployee")
    public Result add(@Valid @RequestBody Employee employee) {
        return this.employeeService.add(employee);
    }

    @PostMapping("/updateEmployee")
    public Result update(@RequestBody Employee employee) {
        return this.employeeService.update(employee);
    }

    @PostMapping("/deleteEmployee")
    public Result delete(@RequestBody Employee employee) {
        return this.employeeService.delete(employee);
    }
}
