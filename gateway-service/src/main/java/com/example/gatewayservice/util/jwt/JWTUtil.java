package com.example.gatewayservice.util.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;
import io.jsonwebtoken.impl.DefaultJws;

import java.nio.charset.StandardCharsets;
import java.time.ZonedDateTime;
import java.util.Date;

public class JWTUtil {
    private String secretKey="2dkfgn5mldddpwl3mrmwkdfm448fkcms932kdfkdm4m4meddkskdsmfmdkk4kk3kk4k3";

    private long expire = 60 * 24 * 30;

//    JWT 토큰 생성
    public String generateToken(String content) throws Exception {
        return Jwts.builder()
                .setIssuedAt(new Date())
                .setExpiration(Date.from(ZonedDateTime.now().plusMinutes(expire).toInstant()))
                .claim("sub",content)
                .signWith(SignatureAlgorithm.HS256,secretKey.getBytes(StandardCharsets.UTF_8))
                .compact();
    }

    public String validateAndExtract(String tokenStr){
        String contentValue = null;
        try {
            DefaultJws defaultJws = (DefaultJws) Jwts.parser()
                    .setSigningKey(secretKey.getBytes(StandardCharsets.UTF_8))
                    .parseClaimsJws(tokenStr);

            DefaultClaims claims = (DefaultClaims) defaultJws.getBody();

            contentValue = claims.getSubject();
        } catch (Exception ex){
            ex.printStackTrace();
            contentValue = null;
        }

        return contentValue;
    }


}
