package com.banking_app.Banking_v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages ="com.banking_app.Banking_v1.Repository" )
@SpringBootApplication
public class BankingV1Application {

	public static void main(String[] args) {
		SpringApplication.run(BankingV1Application.class, args);
	}

}
