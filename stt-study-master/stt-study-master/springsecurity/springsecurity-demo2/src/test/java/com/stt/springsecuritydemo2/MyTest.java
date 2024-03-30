package com.stt.springsecuritydemo2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class MyTest {

    @Autowired
    public PasswordEncoder passwordEncoder;
    // 生成密码加密后的字符串

    @Test
    public void test1() {
        String pass = "123456";
        // 编码
        String result = passwordEncoder.encode(pass);
        System.out.println("result===>" + result);
        // 匹配密码
        boolean isTrue = passwordEncoder.matches("111111",result);
        System.out.println("isTrue===>" + isTrue);
    }
}
