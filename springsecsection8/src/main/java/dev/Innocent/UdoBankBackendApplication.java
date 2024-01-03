package dev.Innocent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@ComponentScan("dev.Innocent.controller") // Optional
@EnableJpaRepositories("dev.Innocent.repository") // Optional
@EntityScan("dev.Innocent.model") // Optional
@EnableWebSecurity(debug = true) // Optional
public class UdoBankBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(UdoBankBackendApplication.class, args);
	}

}
