package com.stt.springsecuritydemo9.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // 配置，启用rememberMe功能
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 关闭csrf
        http.csrf(csrf -> csrf.disable());
        // 配置请求拦截策略
        http.authorizeHttpRequests(auth -> auth.requestMatchers("/oauth/notify","/to_login").permitAll().anyRequest().authenticated());
        // 使用SpringSecurity默认的登录页面
        http.formLogin(Customizer.withDefaults());
        // 开启oauth登陆
        http.oauth2Login(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(this.giteeClientRegistration());
    }
    // 配置giee的授权登录信息
    private ClientRegistration giteeClientRegistration() {
        return ClientRegistration.withRegistrationId("gitee")
                .clientId("2b6d84c6dde313dc3c85c0693182e3cd8319f94ab31ef0beb56d01c149f8b4ce")
                .clientSecret("d1d1eb6c4ba0098da76c08e6339f3f31122dad8527ea50b25238d42c446e0122")
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .redirectUri("http://localhost:8080/login/oauth2/code/gitee")
                .scope("user_info")
                .authorizationUri("https://gitee.com/oauth/authorize")
                .tokenUri("https://gitee.com/oauth/token")
                .userInfoUri("https://gitee.com/api/v5/user")
                .userNameAttributeName("name")
                .build();
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
