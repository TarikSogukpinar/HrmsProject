package hrmsproject.api.controllers;

import hrmsproject.business.abstracts.JobPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

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
    public ResponseEntity<?> getAll() {
        var result = this.positionService.getAll();
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }
    @GetMapping("/getFindByJobTitle")
    public ResponseEntity<?> getFindByJobTitle(String title) {
        var result = this.positionService.findByJobTitle(title);
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }
    @GetMapping("/getFindByCreateDate")
    public ResponseEntity<?> findByCreatedDate(LocalDate createDate) {
        var result = this.positionService.findByCreatedDate(createDate);
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }


}
