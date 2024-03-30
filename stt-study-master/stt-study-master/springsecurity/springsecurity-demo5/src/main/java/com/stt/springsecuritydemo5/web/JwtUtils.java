package com.stt.springsecuritydemo5.web;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class JwtUtils {

    private String secret = "qwertyujklmnbfdsa";
    // 创建token
    public String createJwt(Map<String,Object> claims) {
        String jwtJson = Jwts.builder()
                .setIssuedAt(new Date())// 颁发时间
                .setClaims(claims)// 声明，即存储用户信息
                .setExpiration(new Date(System.currentTimeMillis() + 300000))// 过期时间
                .signWith(SignatureAlgorithm.HS256,secret)// 加密类型和秘钥
                .compact();// 压缩
        return jwtJson;
    }
    // 解析token
    public Claims parseJWT(String jwtJsonStr) {
        Claims body = Jwts.parser().setSigningKey(secret)
                .parseClaimsJws(jwtJsonStr)
                .getBody();
        return body;
    }


}
