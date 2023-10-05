package dio.web.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import dio.web.api.model.User;
import dio.web.api.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<User> getUsers() {
        return repository.findAll();
    }

    @GetMapping("/{username}")
    public User find(@PathVariable("username") String username) {
        return repository.findByUsername(username);
    }

    @PostMapping
    public void save(@RequestBody User user) {
        repository.save(user);
    }

    @PutMapping
    public void update(@RequestBody User user) {
        repository.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        repository.deleteById(id);
    }

}
