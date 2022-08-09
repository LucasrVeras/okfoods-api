package br.com.okfoodsapi.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import br.com.okfoodsapi.OkfoodsApiApplication;
import br.com.okfoodsapi.domain.models.Cuisine;

public class RegistrationCuisineMain{
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = 
				new SpringApplicationBuilder(OkfoodsApiApplication.class)
					.web(WebApplicationType.NONE)
					.run(args);
		
		CuisineRegistration cuisineRegistration = applicationContext
				.getBean(CuisineRegistration.class);
		
		var cuisine1 = new Cuisine();
		cuisine1.setName("Brasilian");
		
		var cuisine2 = new Cuisine();
		cuisine2.setName("Japanese");
		
		cuisineRegistration.addCuisine(cuisine1);
		cuisineRegistration.addCuisine(cuisine2);
	}
}
