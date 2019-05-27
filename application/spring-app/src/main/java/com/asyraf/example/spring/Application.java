package com.asyraf.example.spring;

import com.asyraf.example.db.psql.configuration.PSQLConfiguration;
import com.asyraf.example.db.psql.domain.BaseDomain;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@ComponentScan(value = {"com.asyraf.example"})
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
@EnableJpaRepositories(value = {"com.asyraf.example.db.psql.repo"})
@EntityScan(value = {"com.asyraf.example.db.psql.po"})
@EnableAsync
// I don't use Jmx and web socket, so I comment them.
@Import({
	JacksonAutoConfiguration.class,
	PropertySourcesPlaceholderConfigurer.class,
	PSQLConfiguration.class,
	ThymeleafAutoConfiguration.class})
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	private static String getClassResource(Class<?> klass) {
		return klass.getClassLoader().getResource(
			klass.getName().replace('.', '/') + ".class").toString();
	}
}

