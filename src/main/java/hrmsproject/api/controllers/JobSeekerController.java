package hrmsproject.api.controllers;

import hrmsproject.business.abstracts.JobSeekerService;
import hrmsproject.core.utilities.results.DataResult;
import hrmsproject.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/getAllSeeker")
    public DataResult<List<JobSeeker>> getAll() {
        return this.jobSeekerService.getAll();
    }
    @GetMapping("/getSeekerByFirstName")
    public DataResult<JobSeeker> findJobSeekerByFirstName(String firstName) {
        return this.jobSeekerService.findJobSeekerByFirstName(firstName);
    }
    @GetMapping("/getSeekerByLastName")
    public DataResult<JobSeeker> findJobSeekerByLastName(String lastName) {
        return this.jobSeekerService.findJobSeekerByLastName(lastName);
    }
    @GetMapping("/getSeekerByDateOfBirth")
    public DataResult<JobSeeker> findJobSeekerDateOfBirth(LocalDate dateOfBirth) {
        return this.jobSeekerService.findJobSeekerDateOfBirth(dateOfBirth);
    }
    @GetMapping("/getSeekerByNationalId")
    public DataResult<JobSeeker> findJobSeekerByNationalId(String nationalId) {
        return this.jobSeekerService.findJobSeekerByNationalId(nationalId);
    }
}
