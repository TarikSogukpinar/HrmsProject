package hrmsproject.api.controllers;

import hrmsproject.business.abstracts.EmployerService;
import hrmsproject.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {
    private final EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService) {
        super();
        this.employerService = employerService;
    }

    @GetMapping("/getAllEmployers")
    public ResponseEntity<?> getAll() {
        var result =  this.employerService.getAll();
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/addEmployers")
    public ResponseEntity<?> add(@Valid @RequestBody Employer employer) {
        var result = this.employerService.add(employer);
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/updateEmployers")
    public ResponseEntity<?> update(@RequestBody Employer employer) {
        var result = this.employerService.update(employer);
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/deleteEmployers")
    public ResponseEntity<?> delete(@RequestBody Employer employer) {
        var result = this.employerService.delete(employer);
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }
}
