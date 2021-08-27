package com.example.userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
@Entity
public class UserEntity {
    @Id @GeneratedValue
    private Long id;

    @NotNull
    private String email;

    @NotNull
    private String userPwd;


    @NotNull
    private String name;
    private int age;
    private String sex;
    private String birth;

    @NotNull
    private String phoneNumber;

    public void changeInfo(String name, int age, String sex, String birth){
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.birth = birth;
    }

    public void changePassword(String userPwd){
        this.userPwd = userPwd;
    }
}
