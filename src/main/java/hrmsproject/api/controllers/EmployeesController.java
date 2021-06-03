package hrmsproject.api.controllers;

import hrmsproject.business.abstracts.EmployeeService;
import hrmsproject.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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


    @GetMapping("/getAllEmployee")
    public ResponseEntity<?> getAll() {
        var result = this.employeeService.getAll();
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<?>add(@Valid @RequestBody Employee employee) {
        var result =  this.employeeService.add(employee);
        if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/updateEmployee")
    public ResponseEntity<?> update(@RequestBody Employee employee) {
        var result = this.employeeService.update(employee);
        if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);

    }

    @PostMapping("/deleteEmployee")
    public ResponseEntity<?> delete(@RequestBody Employee employee) {
        var result = this.employeeService.delete(employee);
        if (!result.isSuccess()){
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }
}
