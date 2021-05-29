package hrmsproject.api.controllers;

import hrmsproject.business.abstracts.JobPositionService;
import hrmsproject.core.utilities.results.DataResult;
import hrmsproject.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/jobPositions")
public class JobPositionController {

    private final JobPositionService positionService;

    @Autowired
    public JobPositionController(JobPositionService positionService) {
        super();
        this.positionService = positionService;
    }

    @GetMapping("/getAllPositions")
    public DataResult<List<JobPosition>> getAll() {
        return this.positionService.getAll();
    }
    @GetMapping("/getFindByJobTitle")
    public DataResult<JobPosition> getFindByJobTitle(String title) {
        return this.positionService.findByJobTitle(title);
    }
    @GetMapping("/getFindByCreateDate")
    public DataResult<JobPosition> findByCreatedDate(LocalDate createDate) {
        return this.positionService.findByCreatedDate(createDate);
    }


}
