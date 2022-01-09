package com.manhpd.mvendors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BankHexagonApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(BankHexagonApplication.class);
        app.run(args);
    }
}
