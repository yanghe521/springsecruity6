package com.stt.springsecuritydemo10.config;

import com.stt.springsecuritydemo10.handler.MyLogoutSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private MyLogoutSuccessHandler logoutSuccessHandler;
    /**
     * 配置过滤器链，对login接口放行
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());
        // 放行login接口
        http.authorizeHttpRequests(auth -> auth.requestMatchers("/auth/**","/logout").permitAll()
                .anyRequest().authenticated()
        );
        // 配置退出登录
        http.logout(logout -> logout.logoutSuccessHandler(logoutSuccessHandler).deleteCookies("rememberMe"));
        return http.build();
    }

}
