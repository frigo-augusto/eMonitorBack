package com.example.emonitorback;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {


    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get-users")
    public List<User> getUser(){
        return userService.findAll();
    }

    @PostMapping("/insert-user")
    public void insertUser(@RequestBody UserDto userDto){
        User user = userDto.getUser();
        userService.save(user);
    }
}
