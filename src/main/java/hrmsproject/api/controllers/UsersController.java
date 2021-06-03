package hrmsproject.api.controllers;

import hrmsproject.business.abstracts.UserService;
import hrmsproject.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        super();
        this.userService = userService;
    }


    @GetMapping("/getAllUsers")
    public ResponseEntity<?> getAll() {
        var result = this.userService.getAll();
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/addUsers")
    public ResponseEntity<?> add(@Valid @RequestBody User user) throws Exception {
        var result = this.userService.add(user);
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/updateUsers")
    public ResponseEntity<?> update(@RequestBody User user) {
        var result = this.userService.update(user);
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/deleteUsers")
    public ResponseEntity<?> delete(@RequestBody User user) {
        var result = this.userService.delete(user);
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result);
        }
        return ResponseEntity.ok(result);
    }
}
