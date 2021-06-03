package hrmsproject.api.controllers;

import hrmsproject.business.abstracts.JobExperienceService;
import hrmsproject.entities.concretes.ForeignLanguage;
import hrmsproject.entities.concretes.JobExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/jobExperiences")
public class JobExperiencesController {
    private final JobExperienceService jobExperienceService;

    @Autowired
    public JobExperiencesController(JobExperienceService jobExperienceService) {
        this.jobExperienceService = jobExperienceService;
    }

    @GetMapping("/getAllJobExperiences")
    public ResponseEntity<?> getAll() {
        var result = this.jobExperienceService.getAll();
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/addJobExperiences")
    public ResponseEntity<?> add(@Valid @RequestBody JobExperience jobExperience) {
        var result = this.jobExperienceService.add(jobExperience);
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

}
