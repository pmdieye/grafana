package com.grafana.demo;

import com.grafana.demo.entities.Produit;
import com.grafana.demo.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(ProductRepository productRepository){
		return args -> {
			productRepository.save(Produit.builder().name("computer").price(25000.0).build());
			productRepository.save(Produit.builder().name("smart computer").price(25000.0).build());
			productRepository.save(Produit.builder().name("phone").price(25000.0).build());
			productRepository.findAll().forEach(System.out::println);

		};
	}
}
