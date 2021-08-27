package com.example.userservice.repository;

import com.example.userservice.dto.RequestUserDto;
import com.example.userservice.dto.ResponseUserDto;
import com.example.userservice.entity.UserEntity;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.http.ResponseEntity;

public interface UserRepositoryCustom {

    UserEntity modify(RequestUserDto dto);

    UserEntity login(String email, String password);
}
