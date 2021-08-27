package com.example.userservice.controller;

import com.example.userservice.dto.JWTDto;
import com.example.userservice.dto.LoginDto;
import com.example.userservice.dto.RequestUserDto;
import com.example.userservice.dto.ResponseUserDto;
import com.example.userservice.service.UserService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-service")
@RequiredArgsConstructor
public class UserController {

    final private UserService userService;

//    회원가입
    @ApiOperation(value="회원가입")
    @PostMapping("/user")
    public Long createUser(@RequestBody RequestUserDto dto){
        return userService.createUser(dto);
    }
//    정보수정
    @ApiOperation(value="회원정보 수정")
    @PutMapping("/user")
    public ResponseEntity<ResponseUserDto> modify(@RequestBody RequestUserDto dto){
        return userService.modify(dto);
    }
//    로그인
    @ApiOperation(value="로그인" , notes = "[응답코드]\n로그인 성공 : 200\n로그인 실패 : 404\n 로그인 성공시 token 발급")
    @PostMapping("/login")
    public ResponseEntity<JWTDto> login(@RequestBody LoginDto loginDto){
        System.out.println("로그인 감지 : " + loginDto.getEmail());
        return userService.login(loginDto.getEmail(),loginDto.getPassword());
    }
}
