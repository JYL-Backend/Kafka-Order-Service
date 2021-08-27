package com.example.userservice.repository;

import com.example.userservice.dto.RequestUserDto;
import com.example.userservice.dto.ResponseUserDto;
import com.example.userservice.entity.QUserEntity;
import com.example.userservice.entity.UserEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

import static com.example.userservice.entity.QUserEntity.userEntity;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom{

    private final EntityManager em;
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public UserEntity login(RequestUserDto dto) {
        return jpaQueryFactory.selectFrom(userEntity)
                .where(userEntity.email.eq(dto.getEmail()), userEntity.userPwd.eq(dto.getUserPwd()))
                .fetchOne();
    }

    // 회원정보 수정
    @Override
    public UserEntity modify(RequestUserDto dto) {

        UserEntity userEntity = jpaQueryFactory.selectFrom(QUserEntity.userEntity)
                .where(QUserEntity.userEntity.email.eq(dto.getEmail()))
                .fetchOne();
        userEntity.changeInfo(dto.getName(), dto.getAge(), dto.getSex(), dto.getBirth());
        em.persist(userEntity);

        return userEntity;
    }
}
