package hrmsproject.api.controllers;

import hrmsproject.business.abstracts.SchoolService;
import hrmsproject.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/schools")
public class SchoolsController {
    private final SchoolService schoolService;

    @Autowired
    public SchoolsController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping("/getAllSchool")
    public ResponseEntity<?> getAll() {
        var result = this.schoolService.getAll();
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/addSchool")
    public ResponseEntity<?> add(@Valid @RequestBody School school) {
        var result = this.schoolService.add(school);
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }
}
