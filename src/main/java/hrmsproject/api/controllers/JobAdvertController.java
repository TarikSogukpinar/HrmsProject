package hrmsproject.api.controllers;

import hrmsproject.business.abstracts.JobAdvertService;
import hrmsproject.core.utilities.results.DataResult;
import hrmsproject.core.utilities.results.Result;
import hrmsproject.entities.concretes.JobAdvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobAdvert")
public class JobAdvertController {

    private final JobAdvertService jobAdvertService;

    @Autowired
    public JobAdvertController(JobAdvertService jobAdvertService) {
        super();
        this.jobAdvertService = jobAdvertService;
    }


    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody JobAdvert jobAdvert) {
        var result = this.jobAdvertService.add(jobAdvert);
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        var result = this.jobAdvertService.getAll();
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/findBySalaryMax")
    public ResponseEntity<?> findBySalaryMax(int maxSalary) {
        var result = this.jobAdvertService.findBySalaryMax(maxSalary);
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/findBySalaryMin")
    public ResponseEntity<?> findBySalaryMin(int minSalary) {
        var result = this.jobAdvertService.findBySalaryMin(minSalary);
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/findByEmployerId")
    public ResponseEntity<?> findByEmployerId(int id) {
        var result = this.jobAdvertService.findByEmployerId(id);
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }


    @PostMapping("/changeOpenToClose")
    public ResponseEntity<?> changeOpenToClose(int id) {
        var result = this.jobAdvertService.changeOpenToClose(id);
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getAllOpenJobAdvertList")
    public ResponseEntity<?> getAllOpenJobAdvertList() {
        var result = this.jobAdvertService.getAllOpenJobAdvertList();
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getAllCloseJobAdvertList")
    public ResponseEntity<?> getAllCloseJobAdvertList() {
        var result = this.jobAdvertService.getAllCloseJobAdvertList();
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }


    @GetMapping("/findAllByOrderByPublishedAt")
    public ResponseEntity<?> findAllByOrderByPublishedAt() {
        var result = this.jobAdvertService.findAllByOrderByPublishedAt();
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }


}