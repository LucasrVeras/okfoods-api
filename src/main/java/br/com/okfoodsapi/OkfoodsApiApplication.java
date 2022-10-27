package br.com.okfoodsapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.okfoodsapi.infrastructure.repositories.CustomJpaRepositoryImpl;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class)
public class OkfoodsApiApplication implements CommandLineRunner {
		
	public static void main(String[] args) {
		SpringApplication.run(OkfoodsApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("OK!!!");
	}
}
