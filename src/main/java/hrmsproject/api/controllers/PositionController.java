package hrmsproject.api.controllers;

import hrmsproject.business.abstracts.PositionService;
import hrmsproject.entities.concretes.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/positions")
public class PositionController {

    private PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        super();
        this.positionService = positionService;
    }

    @GetMapping("/getall")
    public List<Position> getAll() {
        return this.positionService.getAll();
    }

}
