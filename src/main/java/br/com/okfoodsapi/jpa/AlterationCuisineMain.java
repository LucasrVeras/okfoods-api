package br.com.okfoodsapi.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import br.com.okfoodsapi.OkfoodsApiApplication;
import br.com.okfoodsapi.domain.models.Cuisine;

public class AlterationCuisineMain{
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = 
				new SpringApplicationBuilder(OkfoodsApiApplication.class)
					.web(WebApplicationType.NONE)
					.run(args);
		
		CuisineRegistration cuisineRegistration = applicationContext
				.getBean(CuisineRegistration.class);
	
		Cuisine cuisine = new Cuisine();
		cuisine.setId(1L);
		cuisine.setName("French");
		
		cuisineRegistration.save(cuisine);
	}
}
