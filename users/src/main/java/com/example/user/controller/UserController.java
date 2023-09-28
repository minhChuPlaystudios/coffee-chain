package com.example.user.controller;

import com.example.user.dto.UserRegistInfo;
import com.example.user.entity.User;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author minh.chu
 * @since 21/09/2023
 */
@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;


    @PostMapping("")
    public ResponseEntity<User> register(@RequestBody UserRegistInfo userRegistInfo) {
        return new ResponseEntity<>(userService.saveUser(userRegistInfo.toUser()), HttpStatus.OK);
    }

    @GetMapping("/{userName}")
    public ResponseEntity<User> getUserByUserName(@PathVariable String userName) {
        return new ResponseEntity<>(userService.findUserByUserName(userName), HttpStatus.OK);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
