package com.fullstackfran.starter;

import com.fullstackfran.starter.config.PizzaConfig;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log
public class PizzaApplication implements CommandLineRunner {
	private PizzaConfig pizzaConfig;


	public static void main(String[] args) {
		SpringApplication.run(PizzaApplication.class, args);
	}

	PizzaApplication(PizzaConfig pizzaConfig) {
		this.pizzaConfig = pizzaConfig;
	}

	@Override
	public void run(final String...args) {
		log.info(
				String.format("I want a %s crust pizza, with a %s and %s sauce",
				pizzaConfig.getCrust(),
				pizzaConfig.getTopping(),
				pizzaConfig.getSauce()));
	}

}
