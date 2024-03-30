package com.stt.springsecuritydemo6;

import com.stt.springsecuritydemo6.web.JwtUtils;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;

@SpringBootTest
class SpringsecurityDemo4ApplicationTests {

    @Autowired
    private JwtUtils jwtUtils;

    @Test
    public void test1() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id",1L);
        map.put("username","蒜头");
        map.put("perms", Arrays.asList("p1","p2","p3"));
        String token = jwtUtils.createToken(map);
        System.out.println("token====>" + token);
    }

    @Test
    public void test2() {
        Claims claims = jwtUtils.parseToken("eyJhbGciOiJIUzI1NiJ9.eyJwZXJtcyI6WyJwMSIsInAyIiwicDMiXSwiaWQiOjEsImV4cCI6MTcwMDM3NTg3NiwiaWF0IjoxNzAwMzc0MDc2LCJ1c2VybmFtZSI6IuiSnOWktCJ9.8kxg6SrrgiK8tWcAx6kVk2q-un2hWBoLUtBqCrcyjY0");
        System.out.println("claims=======>" + claims);
    }
}
