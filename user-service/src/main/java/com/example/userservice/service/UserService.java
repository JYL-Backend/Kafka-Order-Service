package com.example.userservice.service;

import com.example.userservice.dto.RequestUserDto;
import com.example.userservice.dto.ResponseUserDto;
import com.example.userservice.entity.UserEntity;

public interface UserService {
    ResponseUserDto findUser(Long id);
    Long createUser(RequestUserDto dto);





    default ResponseUserDto toResponseDto(UserEntity userEntity) {
        return ResponseUserDto.builder()
                .age(userEntity.getAge())
                .userId(userEntity.getUserId())
                .email(userEntity.getEmail())
                .name(userEntity.getName())
                .phoneNumber(userEntity.getPhoneNumber())
                .build();
    }
    default RequestUserDto toRequestDto(UserEntity userEntity){
        return RequestUserDto.builder()
                .userId(userEntity.getUserId())
                .age(userEntity.getAge())
                .email(userEntity.getEmail())
                .name(userEntity.getName())
                .phoneNumber(userEntity.getPhoneNumber())
                .build();
    }
    default UserEntity requestToEntity(RequestUserDto dto){
        return UserEntity.builder()
                .userId(dto.getUserId())
                .age(dto.getAge())
                .email(dto.getEmail())
                .name(dto.getName())
                .userPwd(dto.getUserPwd())
                .phoneNumber(dto.getPhoneNumber())
                .build();
    }

}
