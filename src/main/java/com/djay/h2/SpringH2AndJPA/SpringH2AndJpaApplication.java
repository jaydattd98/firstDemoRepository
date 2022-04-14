package com.djay.h2.SpringH2AndJPA;

import com.djay.h2.SpringH2AndJPA.Entity.Country;
import com.djay.h2.SpringH2AndJPA.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.djay.h2.SpringH2AndJPA")
public class SpringH2AndJpaApplication implements CommandLineRunner {

	@Autowired
	CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringH2AndJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		countryRepository.saveCountry(new Country("IN","INDIA"));
		countryRepository.saveCountry(new Country("US","USA"));
		countryRepository.saveCountry(new Country("JP","JAPAN"));
	}
}
