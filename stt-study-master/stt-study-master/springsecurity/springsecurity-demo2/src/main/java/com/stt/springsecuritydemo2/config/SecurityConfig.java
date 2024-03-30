package com.stt.springsecuritydemo2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.authentication.PasswordEncoderParser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 使用的是 SpringSecurity6.1.5，配置类有一些变化
 * 1、该类不再需要继承其他的Security定义的类
 * 2、需要使用 @Configuration 才会被Spring容器加载
 * 3、废弃了很多方法，比如and()方法，建议使用Lambda表示实现
 */
@Configuration
// 标记为一个Security类，启用SpringSecurity的自定义配置
@EnableWebSecurity
public class SecurityConfig {

    // 自定义用户名和密码
    // UserDetailsService：根据用户名加载用户，找到的话返回用户信息【UserDetails类型】
    // UserDetails：存储了用户的信息
    @Bean
    public UserDetailsService userDetailsService() {
        // 定义用户信息
        // 构建管理员
        UserDetails adminUser = User.withUsername("xiaozhang")
                .password("$2a$10$csvUZnj/VG6wBkooT/mewO.WbJesVCiHqEoWTyQrOYTKJvk3xpQb6")
                .roles("admin", "user")
                .build();
        // 构建普通用户
        UserDetails vipUser = User.withUsername("user")
                .password("$2a$10$csvUZnj/VG6wBkooT/mewO.WbJesVCiHqEoWTyQrOYTKJvk3xpQb6")
                .roles("user")
                .build();
        // 将用户存储到SpringSecurity中
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        // 创建两个用户，SpringSecurity在运行时就会知道有两个用户
        userDetailsManager.createUser(adminUser);
        userDetailsManager.createUser(vipUser);
        return userDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // 构建密码编码器
        return new BCryptPasswordEncoder();
    }
}
