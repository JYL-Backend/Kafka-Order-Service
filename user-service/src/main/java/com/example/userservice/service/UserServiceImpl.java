package com.example.userservice.service;

import com.example.userservice.dto.JWTDto;
import com.example.userservice.dto.RequestUserDto;
import com.example.userservice.dto.ResponseUserDto;
import com.example.userservice.entity.UserEntity;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.security.util.JWTUtil;
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
    public ResponseEntity<JWTDto> login(String email, String password) {
        UserEntity userEntity =  null;
        ResponseUserDto responseUserDto = null;
        String token = null;
        try {
            userEntity = userRepository.login(email, password);

            responseUserDto = ResponseUserDto.builder()
                    .birth(userEntity.getBirth())
                    .age(userEntity.getAge())
                    .email(userEntity.getEmail())
                    .name(userEntity.getName())
                    .sex(userEntity.getSex())
                    .phoneNumber(userEntity.getPhoneNumber())
                    .build();

            token = new JWTUtil().generateToken(userEntity.getEmail());
        } catch (Exception ex){}

        return userEntity==null
                ? new ResponseEntity<>(null, HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(JWTDto.builder().token(token).build(),HttpStatus.OK);
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
