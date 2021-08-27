package com.example.userservice.service;

import com.example.userservice.dto.RequestUserDto;
import com.example.userservice.dto.ResponseUserDto;
import com.example.userservice.entity.UserEntity;
import com.example.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    /**
     * 회원가입
     */
    @Override
    public Long createUser(RequestUserDto dto) {
        UserEntity userEntity = requestToEntity(dto);
        UserEntity saveUser = userRepository.save(userEntity);
        return saveUser.getId();
    }

    /**
     * 로그인
     */
    @Override
    public ResponseEntity<ResponseUserDto> login(RequestUserDto dto) {
        UserEntity userEntity =  null;
        ResponseUserDto responseUserDto = null;
        try {
            userEntity = userRepository.login(dto);

            responseUserDto = ResponseUserDto.builder()
                    .birth(userEntity.getBirth())
                    .age(userEntity.getAge())
                    .email(userEntity.getEmail())
                    .name(userEntity.getName())
                    .sex(userEntity.getSex())
                    .phoneNumber(userEntity.getPhoneNumber())
                    .build();
        } catch (Exception ex){}

        return userEntity==null
                ? new ResponseEntity<>(null, HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(null,HttpStatus.OK);
    }

    /**
     * 회원정보수정
     */
    @Override
    @Transactional
    public ResponseEntity<ResponseUserDto> modify(RequestUserDto dto) {
        UserEntity userEntity = userRepository.modify(dto);
        ResponseUserDto responseUserDto = toResponseDto(userEntity);
        return new ResponseEntity<>(responseUserDto,HttpStatus.OK);
    }
}
