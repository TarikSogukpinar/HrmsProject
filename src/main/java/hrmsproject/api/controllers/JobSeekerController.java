package hrmsproject.api.controllers;

import hrmsproject.business.abstracts.JobSeekerService;
import hrmsproject.core.utilities.results.DataResult;
import hrmsproject.core.utilities.results.Result;
import hrmsproject.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/jobSeekers")
public class JobSeekerController {
    private final JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekerController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody JobSeeker jobSeeker) {
        var result = this.jobSeekerService.add(jobSeeker);
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getAllSeeker")
    public ResponseEntity<?> getAll() {
        var result = this.jobSeekerService.getAll();
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getSeekerByFirstName")
    public ResponseEntity<?> findJobSeekerByFirstName(String firstName) {
        var result = this.jobSeekerService.findJobSeekerByFirstName(firstName);
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getSeekerByLastName")
    public ResponseEntity<?> findJobSeekerByLastName(String lastName) {
        var result = this.jobSeekerService.findJobSeekerByLastName(lastName);
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getSeekerByDateOfBirth")
    public ResponseEntity<?> findJobSeekerDateOfBirth(LocalDate dateOfBirth) {
        var result = this.jobSeekerService.findJobSeekerDateOfBirth(dateOfBirth);
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getSeekerByNationalId")
    public ResponseEntity<?> findJobSeekerByNationalId(String nationalId) {
        var result = this.jobSeekerService.findJobSeekerByNationalId(nationalId);
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }
}
