package com.asyraf.example.spring;

import com.asyraf.config.SpringConfig;

import com.asyraf.example.db.psql.PSQLServiceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import org.springframework.scheduling.annotation.EnableAsync;

@ComponentScan(value = {"com.asyraf.example"})
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
@EnableAsync
// I don't use Jmx and web socket, so I comment them.
@Import({
	JacksonAutoConfiguration.class,
	PropertySourcesPlaceholderConfigurer.class,
	ThymeleafAutoConfiguration.class})
public class Application {
	public static void main(String[] args) {
//		System.out.println("=========================" + getClassResource(PSQLServiceConfiguration.class));
		SpringApplication.run(Application.class, args);
	}

	private static String getClassResource(Class<?> klass) {
		return klass.getClassLoader().getResource(
			klass.getName().replace('.', '/') + ".class").toString();
	}
}

