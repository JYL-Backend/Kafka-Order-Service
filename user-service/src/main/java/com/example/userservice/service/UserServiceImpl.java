package com.example.userservice.service;

import com.example.userservice.dto.RequestUserDto;
import com.example.userservice.dto.ResponseUserDto;
import com.example.userservice.entity.UserEntity;
import com.example.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public ResponseUserDto findUser(Long id) {
        Optional<UserEntity> result = userRepository.findById(id);
        if(result.isEmpty()) return null;
        UserEntity userEntity = result.get();

        return toResponseDto(userEntity);
    }

    public Long createUser(RequestUserDto dto) {
        UserEntity userEntity = requestToEntity(dto);
        return userRepository.save(userEntity).getId();
    }
}
