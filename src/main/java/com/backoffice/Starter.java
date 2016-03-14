package com.backoffice;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
@EnableAutoConfiguration
public class Starter {

	@Value("${imageRootFolder}")
	private String root = "";

	public static void main(final String[] args) {
		SpringApplication.run(Starter.class, args);
	}

	@Bean
	CommandLineRunner init() {
		return (final String[] args) -> {
			new File(root).mkdir();
		};
	}

	public void setRoot(final String root) {
		this.root = root;
	}

}
