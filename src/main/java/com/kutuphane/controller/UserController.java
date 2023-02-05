package com.kutuphane.controller;

import com.kutuphane.dto.UserDto;
import com.kutuphane.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping
public class UserController {

    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> createUser(@Valid @RequestBody UserDto userDto){
        userService.saveUser(userDto);
        String message="User has created succesfully";
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }


}
