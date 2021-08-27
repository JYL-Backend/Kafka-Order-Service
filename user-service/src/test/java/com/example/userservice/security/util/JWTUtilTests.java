package com.example.userservice.security.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JWTUtilTests {
    JWTUtil jwtUtil;
    @BeforeEach
    public void testBefore(){
        jwtUtil = new JWTUtil();
    }
    @Test
    public void testEncode() throws Exception {
        //given
        String email = "user1@naver.com";
        String str = jwtUtil.generateToken(email);

        System.out.println("str = " + str);
        //when

        //then
    }

    @Test
    public void testValidate() throws Exception {
        //given
        String email = "user1@naver.com";
        String str = jwtUtil.generateToken(email);

        String resultEmail = jwtUtil.validateAndExtract(str);

        System.out.println("resultEmail = " + resultEmail);
        //when

        //then
    }
    @Test
    public void testValidate2() throws Exception {
        //given
        String email = "user1@naver.com";
        String str = jwtUtil.generateToken(email) + "2";

        String resultEmail = jwtUtil.validateAndExtract(str);

        System.out.println("resultEmail = " + resultEmail);
        //when

        //then
    }
}
