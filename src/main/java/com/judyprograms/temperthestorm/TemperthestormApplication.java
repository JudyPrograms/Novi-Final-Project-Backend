package com.judyprograms.temperthestorm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class TemperthestormApplication {

	public static void main(String[] args) {
		SpringApplication.run(TemperthestormApplication.class, args);
	}

	@GetMapping(value = "/")
	public static String sayHello() {
		return "Hello World";
	}

}
