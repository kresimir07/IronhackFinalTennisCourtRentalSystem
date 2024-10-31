package org.example.ironhackfinaltenniscourtrentalsystem.controller;
import org.example.ironhackfinaltenniscourtrentalsystem.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }






}
