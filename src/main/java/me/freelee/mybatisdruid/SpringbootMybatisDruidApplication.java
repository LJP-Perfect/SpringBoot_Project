package me.freelee.mybatisdruid;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(value = "me.freelee.mybatisdruid.mapper")
@SpringBootApplication
public class SpringbootMybatisDruidApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisDruidApplication.class, args);
    }
}
