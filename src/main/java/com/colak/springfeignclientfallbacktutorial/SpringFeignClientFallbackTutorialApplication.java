package com.colak.springfeignclientfallbacktutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringFeignClientFallbackTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFeignClientFallbackTutorialApplication.class, args);
	}

}
