package hrmsproject.api.controllers;

import hrmsproject.business.abstracts.JobAdvertService;
import hrmsproject.core.utilities.results.DataResult;
import hrmsproject.core.utilities.results.Result;
import hrmsproject.entities.concretes.JobAdvert;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Result add(@RequestBody JobAdvert jobAdvert){
        return this.jobAdvertService.add(jobAdvert);
    }

    @GetMapping("/getAll")
    public DataResult<List<JobAdvert>> getAll(){
        return this.jobAdvertService.getAll();
    }

    @GetMapping("/findBySalaryMax")
    public DataResult<JobAdvert> findBySalaryMax(int maxSalary){
        return this.jobAdvertService.findBySalaryMax(maxSalary);
    }
    @GetMapping("/findBySalaryMin")
    public DataResult<JobAdvert> findBySalaryMin(int minSalary){
        return this.jobAdvertService.findBySalaryMin(minSalary);
    }
    @GetMapping("/findByEmployerId")
    public DataResult<JobAdvert> findByEmployerId(int id){
        return this.jobAdvertService.findByEmployerId(id);
    }


    @PostMapping("/changeOpenToClose")
    public Result changeOpenToClose(int id){
        return this.jobAdvertService.changeOpenToClose(id);
    }

    @GetMapping("/getAllOpenJobAdvertList")
    public DataResult<List<JobAdvert>> getAllOpenJobAdvertList(){
        return this.jobAdvertService.getAllOpenJobAdvertList();
    }

    @GetMapping("/findAllByOrderByPublishedAt")
    public DataResult<List<JobAdvert>> findAllByOrderByPublishedAt(){
        return this.jobAdvertService.findAllByOrderByPublishedAt();
    }


}