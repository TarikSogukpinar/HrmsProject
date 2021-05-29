package hrmsproject.api.controllers;

import hrmsproject.business.abstracts.UserService;
import hrmsproject.core.utilities.results.DataResult;
import hrmsproject.core.utilities.results.Result;
import hrmsproject.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public DataResult<List<User>> getAll() {
        return this.userService.getAll();
    }

    @PostMapping("/addUsers")
    public Result add(@Valid @RequestBody User user) throws Exception {
        return this.userService.add(user);
    }

    @PostMapping("/updateUsers")
    public Result update(@RequestBody User user) {
        return this.userService.update(user);
    }

    @PostMapping("/deleteUsers")
    public Result delete(@RequestBody User user) {
        return this.userService.delete(user);
    }
}
