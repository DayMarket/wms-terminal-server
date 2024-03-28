package com.kazanexpress.wms.terminal.server;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {
        "com.kazanexpress.wms.terminal.server"
})
@EnableFeignClients(basePackages = {"com.kazanexpress"})
@EnableConfigurationProperties
@MapperScan(annotationClass = Mapper.class, basePackages = "com.kazanexpress.wms.terminal.server.*")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
