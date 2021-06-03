package hrmsproject.api.controllers;

import hrmsproject.business.abstracts.ForeignLanguageService;
import hrmsproject.entities.concretes.ForeignLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/languages")
public class ForeignLanguagesController {
    private final ForeignLanguageService foreignLanguageService;

    @Autowired
    public ForeignLanguagesController(ForeignLanguageService foreignLanguageService) {
        this.foreignLanguageService = foreignLanguageService;
    }

    @GetMapping("/getAllLanguages")
    public ResponseEntity<?> getAll() {
        var result = this.foreignLanguageService.getAll();
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/addLanguages")
    public ResponseEntity<?> add(@Valid @RequestBody ForeignLanguage foreignLanguage) {
        var result = this.foreignLanguageService.add(foreignLanguage);
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }
}
