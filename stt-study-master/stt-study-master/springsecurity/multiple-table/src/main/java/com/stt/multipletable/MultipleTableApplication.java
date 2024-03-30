package com.stt.multipletable;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.stt.multipletable.mapper")
@SpringBootApplication
public class MultipleTableApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultipleTableApplication.class, args);
    }

}
