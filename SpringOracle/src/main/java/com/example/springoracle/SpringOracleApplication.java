package com.example.springoracle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springoracle.Model.CareLevel;
import com.example.springoracle.repository.OracleRepository;

@SpringBootApplication
public class SpringOracleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringOracleApplication.class, args)
		.getBean(SpringOracleApplication.class).execute();
	}
	
	@Autowired
	private OracleRepository repository;
	
	public void execute() {
		Iterable<CareLevel> carelevel = repository.findAll();
		for(CareLevel cl : carelevel) {
			System.out.println(cl);
		}
	}
}
