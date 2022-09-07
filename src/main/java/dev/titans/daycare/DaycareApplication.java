package dev.titans.daycare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"dev.titans"})
@EntityScan(basePackages = {"dev.titans.entities"})
@EnableJpaRepositories(basePackages = {"dev.titans.repos"})
@EnableMongoRepositories(basePackages = {"dev.titans.repos"})
public class DaycareApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaycareApplication.class, args);
	}

}
