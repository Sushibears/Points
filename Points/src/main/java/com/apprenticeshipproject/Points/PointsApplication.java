package com.apprenticeshipproject.Points;

import com.apprenticeshipproject.Points.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PointsApplication {

	@Autowired
	TransactionRepository repo;
	public static void main(String[] args) {
		SpringApplication.run(PointsApplication.class, args);
	}

}
