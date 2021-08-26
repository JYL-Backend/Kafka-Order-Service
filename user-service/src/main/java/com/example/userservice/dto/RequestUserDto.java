package com.example.userservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestUserDto {
    private String userId;
    private String userPwd;
    private String name;
    private int age;
    private String phoneNumber;
    private String email;
}