package dev.Innocent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("dev.Innocent.controller") // Optional
public class UdoBankBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(UdoBankBackendApplication.class, args);
	}

}
