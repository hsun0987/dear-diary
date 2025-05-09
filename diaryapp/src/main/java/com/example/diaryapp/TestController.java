package com.example.diaryapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    private final UserService userService;

    public TestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/test")
    public String test() {
        return "Hello, World! Application is running.";
    }

    @GetMapping("/test/users")
    public List<User> testUsers() {
        return userService.getAllUsers();
    }
}
