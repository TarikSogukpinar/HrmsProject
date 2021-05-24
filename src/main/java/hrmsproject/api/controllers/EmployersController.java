package hrmsproject.api.controllers;

import hrmsproject.business.abstracts.EmployerService;
import hrmsproject.core.utilities.results.DataResult;
import hrmsproject.core.utilities.results.Result;
import hrmsproject.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {
    private final EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService) {
        super();
        this.employerService = employerService;
    }
    @GetMapping("/getallemployers")
    public DataResult<List<Employer>> getAll() {
        return this.employerService.getAll();
    }
    @PostMapping("/addemployers")
    public Result add(@Valid @RequestBody Employer employer) {
        return this.employerService.add(employer);
    }
    @PostMapping("/updateemployers")
    public Result update(@RequestBody Employer employer) {
        return this.employerService.update(employer);
    }

    @PostMapping("/deleteemployers")
    public Result delete(@RequestBody Employer employer) {
        return this.employerService.delete(employer);
    }
}
