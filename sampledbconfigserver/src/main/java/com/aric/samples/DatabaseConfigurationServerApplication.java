package com.aric.samples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class DatabaseConfigurationServerApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(DatabaseConfigurationServerApplication.class, args);
	}
}
