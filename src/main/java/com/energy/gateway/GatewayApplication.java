package com.energy.gateway;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GatewayApplication {

	public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure()
            .directory(".env")
            .ignoreIfMalformed()
            .ignoreIfMissing()
            .load();
		SpringApplication.run(GatewayApplication.class, args);
	}

}
