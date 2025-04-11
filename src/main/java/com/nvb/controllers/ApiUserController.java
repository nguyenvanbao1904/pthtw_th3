package com.nvb.controllers;

import com.nvb.pojo.User;
import com.nvb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiUserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<User> create(@RequestParam("avatar") MultipartFile avatar, @RequestParam Map<String, String> params) {
        User user = this.userService.addUser(params, avatar);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
