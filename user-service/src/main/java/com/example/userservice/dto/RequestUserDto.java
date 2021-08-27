package com.example.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestUserDto {
    private String email;
    private String name;
    private String sex;
    private String userPwd;
    private String birth;
    private int age;
    private String phoneNumber;
}
