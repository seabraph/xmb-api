package com.xmbapi.controller;

import com.xmbapi.model.User;
import com.xmbapi.model.UserLogin;
import com.xmbapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("register")
    public ResponseEntity<User> register(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.register(user));
    }

    @PostMapping("login")
    public ResponseEntity<UserLogin> login(@RequestBody UserLogin userLogin){
        return new ResponseEntity<>(userService.login(userLogin), HttpStatus.OK);
    }

}
