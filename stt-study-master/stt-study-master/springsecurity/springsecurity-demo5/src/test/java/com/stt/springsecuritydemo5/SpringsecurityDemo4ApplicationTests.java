package com.stt.springsecuritydemo5;

import com.stt.springsecuritydemo5.web.JwtUtils;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
class SpringsecurityDemo4ApplicationTests {

    @Autowired
    private JwtUtils jwtUtils;

    @Test
    public void createToken() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username","蒜头");
        map.put("id",1L);
        map.put("avatar","头像地址");
        String jwt = jwtUtils.createJwt(map);
        System.out.println("jwt========>" + jwt);
    }

    @Test
    public void parseJwt() {
        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiYXZhdGFyIjoi5aS05YOP5Zyw5Z2AIiwiZXhwIjoxNzAwMzA1NTg5LCJ1c2VybmFtZSI6IuiSnOWktCJ9.Rlipr-tbrRIkTb4IHua2NIIT5F-pTPnNkuvhHK7bzXE";
        Claims claims = jwtUtils.parseJWT(jwt);
        System.out.println("claims=======>" + claims);
    }
}
