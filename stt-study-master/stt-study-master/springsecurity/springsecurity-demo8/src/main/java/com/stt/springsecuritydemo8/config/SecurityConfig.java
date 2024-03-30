package com.stt.springsecuritydemo8.config;

import com.stt.springsecuritydemo8.token.DaoCaoPersistentTokenRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private DaoCaoPersistentTokenRepositoryImpl persistentTokenRepository;
    // 配置，启用rememberMe功能
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 关闭csrf
        http.csrf(csrf -> csrf.disable());
        // 配置请求拦截策略
        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
        // 使用SpringSecurity默认的登录页面
        http.formLogin(Customizer.withDefaults());
        // 开启默认的记住我功能
        http.rememberMe(remember -> remember.rememberMeCookieName("rememberMe").tokenRepository(persistentTokenRepository));
        return http.build();
    }

    // 基于内存创建用户
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        return new InMemoryUserDetailsManager(
                User.withUsername("admin")
                        .password("{noop}123456")
                        .build()
        );
    }
}
