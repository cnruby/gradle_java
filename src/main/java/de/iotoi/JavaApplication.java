package de.iotoi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaApplication {
	public static void main(String[]args) {
		SpringApplication.run(JavaApplication.class, args);
	}

	@Bean
	public CommandLineRunner init() {
		return args -> {
			System.out.println("Hello World!");
		};
	}

	@Bean
	public void hello() {
		System.out.println("Hallo Welt!");
	}

	public CommandLineRunner niHao() {
		return args -> {
			System.out.println("世界，你好!");
		};
	}

}