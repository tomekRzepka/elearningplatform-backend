package com.example.elearningplatform;

import com.example.elearningplatform.user.UserDto;
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
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{login}")
    public UserDto getUser(@PathVariable String login) {
        return userService.getUser(login);
    }

    @PostMapping("/add")
    public void addCustomer(@RequestBody UserDto user) {
        userService.addUser(user);
    }

    @PutMapping("/edit/{login}")
    @ResponseStatus(HttpStatus.OK)
    public Boolean editUser(@RequestBody UserDto user) {
        return userService.editUser(user);
    }

    @DeleteMapping("/delete/{login}")
    @ResponseStatus(HttpStatus.OK)
    public void editUser(@PathVariable String login) {
        userService.removeUser(login);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public UserDto loginUser(@RequestBody UserDto user) {
        return userService.userValidation(user);
    }

}
