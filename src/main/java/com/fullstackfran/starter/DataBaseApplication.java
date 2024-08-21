package com.fullstackfran.starter;
import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log
public class DataBaseApplication {
	public static void main(String[] args) {
		SpringApplication.run(DataBaseApplication.class, args);
	}
}
