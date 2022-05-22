package com.adn.alianza;

import com.adn.alianza.services.PreAnalisis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class AlianzaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlianzaApplication.class, args);
	}

}
