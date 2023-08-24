package com.lzm.smartRestaurant;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@ServletComponentScan //开启组件扫描
@SpringBootApplication
@EnableTransactionManagement //开启事务注解的支持
public class SmartRestaurantApplication {
    public static void main(String[] args) {
        SpringApplication.run(SmartRestaurantApplication.class, args);
        log.info("项目启动成功...");
    }
}
