package com.stt.multipletable.config;

import com.stt.multipletable.web.SiteUserDetailsService;
import com.stt.multipletable.web.SysUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 现在使用的是SpringSecurity 6.1.5版本，开启SpringSecurity的自定义配置，
 * 需要使用 @EnableWebSecurity注解，而不再是继承Adpater
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private SysUserDetailsService sysUserDetailsService;

    @Autowired
    private SiteUserDetailsService siteUserDetailsService;

    // 配置SpringSecurity的过滤器链
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 设置登陆接口放行
        http.authorizeHttpRequests(auth -> auth.requestMatchers("/auth/sys_login","/auth/site_login").permitAll().anyRequest().authenticated());
        // 关闭csrf
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }


    // 配置AuthenticationManager，配置两个。一个管理后台用户
    @Primary
    @Bean("sysUserAuthenticationManager")
    public AuthenticationManager sysUserAuthenticationManager(PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        // 关联UserDetailsService
        authenticationProvider.setUserDetailsService(sysUserDetailsService);
        // 关联密码管理器
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        return new ProviderManager(authenticationProvider);
    }


    // 配置AuthenticationManager，管理APP用户
    @Bean("siteUserAuthenticationManager")
    public AuthenticationManager siteUserAuthenticationManager(PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        // 关联UserDetailsService
        authenticationProvider.setUserDetailsService(siteUserDetailsService);
        // 关联密码管理器
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        return new ProviderManager(authenticationProvider);
    }

    /**
     * 密码管理器，会将明文密码转换成密文，加密，而且不能解码
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
