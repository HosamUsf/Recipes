package recipes.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import recipes.Services.UserService;
import recipes.model.User;
import recipes.repositories.UserRepository;

import javax.validation.Valid;
import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("api")
public class UserController {
    private UserService service;
    private UserRepository repository ;



    @PostMapping("/register")
    public User register(@Valid @RequestBody User user) {
        service.register(user);
        return user ;
    }


    @GetMapping("/register")
    public List<User> getUsers() {
        return repository.findAll();

    }
}
