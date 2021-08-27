package com.example.userservice.service;

import com.example.userservice.dto.RequestUserDto;
import com.example.userservice.dto.ResponseUserDto;
import com.example.userservice.entity.UserEntity;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.http.ResponseEntity;

public interface UserService {



    default ResponseUserDto toResponseDto(UserEntity userEntity) {
        return ResponseUserDto.builder()
                .sex(userEntity.getSex())
                .phoneNumber(userEntity.getPhoneNumber())
                .name(userEntity.getName())
                .email(userEntity.getEmail())
                .age(userEntity.getAge())
                .birth(userEntity.getBirth())
                .build();
    }
    default RequestUserDto toRequestDto(UserEntity userEntity){
        return RequestUserDto.builder()
                .sex(userEntity.getSex())
                .age(userEntity.getAge())
                .birth(userEntity.getBirth())
                .email(userEntity.getEmail())
                .name(userEntity.getName())
                .phoneNumber(userEntity.getPhoneNumber())
                .userPwd(userEntity.getUserPwd())
                .build();
    }
    default UserEntity requestToEntity(RequestUserDto dto){
        return UserEntity.builder()
                .email(dto.getEmail())
                .name(dto.getName())
                .sex(dto.getSex())
                .age(dto.getAge())
                .birth(dto.getBirth())
                .userPwd(dto.getUserPwd())
                .phoneNumber(dto.getPhoneNumber())
                .build();
    }

    Long createUser(RequestUserDto dto);

    ResponseEntity<ResponseUserDto> login(RequestUserDto dto);

    ResponseEntity<ResponseUserDto> modify(RequestUserDto dto);
}
