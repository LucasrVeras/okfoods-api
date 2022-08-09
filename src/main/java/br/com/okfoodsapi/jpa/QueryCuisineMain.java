package br.com.okfoodsapi.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import br.com.okfoodsapi.OkfoodsApiApplication;
import br.com.okfoodsapi.domain.models.Cuisine;

public class QueryCuisineMain{
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = 
				new SpringApplicationBuilder(OkfoodsApiApplication.class)
					.web(WebApplicationType.NONE)
					.run(args);
		
		CuisineRegistration cuisineRegistration = applicationContext
				.getBean(CuisineRegistration.class);
	
		List<Cuisine> cuisines = cuisineRegistration.list();
		
		for (Cuisine cuisine : cuisines) {
			System.out.println(cuisine.getName());
		}
	}
}
