package com.guciowons.footballguesser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FootballerGuesserApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballerGuesserApplication.class, args);
	}

}
