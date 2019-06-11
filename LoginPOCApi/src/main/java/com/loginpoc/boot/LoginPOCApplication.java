package com.loginpoc.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages = { "com.loginpoc" })
@EnableCaching
public class LoginPOCApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginPOCApplication.class, args);
	}
}
