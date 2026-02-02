package com.example.rover;

import com.example.rover.core.applesauce.Rover;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RoverApplication {

	static void main(String[] args) {
		SpringApplication.run(RoverApplication.class, args);
	}

    @Bean
    Rover rover() {
        return new Rover();
    }

}
