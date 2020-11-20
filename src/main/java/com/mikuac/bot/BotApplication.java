package com.mikuac.bot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.telegram.telegrambots.ApiContextInitializer;

/**
 * @author Zero
 * @create 2020/10/23 22:50
 */
@Slf4j
@EnableAsync
@EnableScheduling
@SpringBootApplication
public class BotApplication {
    public static void main(String[] args) {
        String welcome = "Hi~";
        // Telegram框架初始化
        ApiContextInitializer.init();
        SpringApplication.run(BotApplication.class, args);
        log.info(welcome);
    }
}