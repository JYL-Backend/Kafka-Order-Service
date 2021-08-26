package com.example.userservice.controller;

import com.example.userservice.dto.RequestUserDto;
import com.example.userservice.dto.ResponseUserDto;
import com.example.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-service")
@RequiredArgsConstructor
public class UserController {

    final private UserService userService;

    @GetMapping("/user/{id}")
    public ResponseUserDto getUser(@PathVariable("id") Long id){
        return userService.findUser(id);
    }

    @PostMapping("/user")
    public Long createUser(@RequestBody RequestUserDto dto){
        return userService.createUser(dto);
    }
}
