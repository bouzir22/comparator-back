package com.example.epi.server;

import com.example.epi.server.model.Product;
import com.example.epi.server.model.Vendor;
import com.example.epi.server.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerApplication {
	@Autowired
private static ProductRepository productRepository;
	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
		;


	}

}
