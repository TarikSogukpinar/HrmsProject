package hrmsproject.api.controllers;

import hrmsproject.business.abstracts.CurriculumVitaeService;
import hrmsproject.entities.concretes.CurriculumVitae;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/cv")
public class CurriculumVitaesController {
    private final CurriculumVitaeService curriculumVitaeService;

    @Autowired
    public CurriculumVitaesController(CurriculumVitaeService curriculumVitaeService) {
        this.curriculumVitaeService = curriculumVitaeService;
    }

    @GetMapping("/getAllCV")
    public ResponseEntity<?> getAll() {
        var result = this.curriculumVitaeService.getAll();
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/addCV")
    public ResponseEntity<?> add(@Valid @RequestBody CurriculumVitae curriculumVitae) {
        var result = this.curriculumVitaeService.add(curriculumVitae);
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

}
