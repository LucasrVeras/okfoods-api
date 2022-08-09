package br.com.okfoodsapi.jpa.cuisine;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import br.com.okfoodsapi.OkfoodsApiApplication;
import br.com.okfoodsapi.domain.models.Cuisine;
import br.com.okfoodsapi.domain.repositories.CuisineRepository;

public class RegistrationCuisineMain{
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = 
				new SpringApplicationBuilder(OkfoodsApiApplication.class)
					.web(WebApplicationType.NONE)
					.run(args);
		
		CuisineRepository cuisineRepository = applicationContext
				.getBean(CuisineRepository.class);
		
		var cuisine1 = new Cuisine();
		cuisine1.setName("Brasilian");
		
		var cuisine2 = new Cuisine();
		cuisine2.setName("Japanese");
		
		cuisineRepository.add(cuisine1);
		cuisineRepository.add(cuisine2);
	}
}
