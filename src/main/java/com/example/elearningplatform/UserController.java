package com.example.elearningplatform;

import com.example.elearningplatform.user.User;
import com.example.elearningplatform.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final UserService userService;


    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{login}")
    public User getUser(@PathVariable String login) {
        return userService.getUser(login);
    }

    @PostMapping("/add")
    public void addCustomer(@RequestBody User user) {
        userService.addUser(user);
    }

    @PutMapping("/edit/{login}")
    @ResponseStatus(HttpStatus.OK)
    public Boolean editUser(@RequestBody User user) {
        return userService.editUser(user);
    }

    @DeleteMapping("/delete/{login}")
    @ResponseStatus(HttpStatus.OK)
    public void editUser(@PathVariable String login) {
        userService.removeUser(login);
    }

    @GetMapping("/login/{login}")
    @ResponseStatus(HttpStatus.OK)
    public boolean loginUser(@PathVariable String login) {
        return userService.userValidation(login);
    }

}
