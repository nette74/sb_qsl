package com.ll.exam.qsl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class QslApplication {
    public static void main(String[] args) {
        SpringApplication.run(QslApplication.class, args);
    }

}
