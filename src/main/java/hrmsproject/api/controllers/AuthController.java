package hrmsproject.api.controllers;

import hrmsproject.business.abstracts.AuthService;
import hrmsproject.core.entities.concretes.User;
import hrmsproject.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;
    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/loginuser")
    public Result login(@RequestBody User user) {
            return this.authService.login(user);

    }
}