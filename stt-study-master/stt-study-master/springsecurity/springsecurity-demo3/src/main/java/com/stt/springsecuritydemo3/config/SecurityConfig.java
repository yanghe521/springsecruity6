package com.stt.springsecuritydemo3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
// 启用基于方法的鉴权
@EnableMethodSecurity
public class SecurityConfig {

    // 配置权限相关的配置
    // 安全框架本质都是一堆的过滤器，称之为过滤器链，每一个过滤器功能都不同
    // to_login不要拦截
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 配置关闭csrf机制，
        http.csrf(csrf -> csrf.disable());
        // 配置请求拦截方式
        http.authorizeHttpRequests(auth ->
                auth.requestMatchers("/to_login").permitAll()
                        .anyRequest().authenticated());
        // 表单、Basic等等
        http.formLogin(form -> form.loginPage("/to_login") // 跳转到自定的登录页面
                .loginProcessingUrl("/doLogin") // 处理前端的请求，与form表单的action一致
                .usernameParameter("username") // 用户名
                .passwordParameter("password") // 密码
                .defaultSuccessUrl("/index") // 请求到index接口上
        );
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // 定义用户信息
        // 构建管理员
        UserDetails adminUser = User.withUsername("xiaozhang")
                .password("$2a$10$csvUZnj/VG6wBkooT/mewO.WbJesVCiHqEoWTyQrOYTKJvk3xpQb6")
                .roles("admin")
                .authorities("test1:show","user:name","user:list")
                .build();
        // 构建普通用户
        UserDetails vipUser = User.withUsername("user")
                .password("$2a$10$csvUZnj/VG6wBkooT/mewO.WbJesVCiHqEoWTyQrOYTKJvk3xpQb6")
                .roles("user")
                .authorities("user:show","goods:show")
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
