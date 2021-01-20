package de.iotoi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaApplication {
	@Value("${web.app.name}") String webAppName;

	@Bean
	public CommandLineRunner init(@Value("${web.app.name}") String appName) {
		return args -> {
			System.out.println(appName + " from init()!");
			System.out.println(webAppName + " from init()!!");
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(JavaApplication.class, args);
	}

}
