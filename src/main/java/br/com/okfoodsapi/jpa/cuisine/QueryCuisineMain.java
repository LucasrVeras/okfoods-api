package br.com.okfoodsapi.jpa.cuisine;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import br.com.okfoodsapi.OkfoodsApiApplication;
import br.com.okfoodsapi.domain.models.Cuisine;
import br.com.okfoodsapi.domain.repositories.CuisineRepository;

public class QueryCuisineMain{
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = 
				new SpringApplicationBuilder(OkfoodsApiApplication.class)
					.web(WebApplicationType.NONE)
					.run(args);
		
		CuisineRepository cuisineRepository = applicationContext
				.getBean(CuisineRepository.class);
	
		List<Cuisine> allCuisines = cuisineRepository.all();
		
		for (Cuisine cuisine : allCuisines) {
			System.out.println(cuisine.getName());
		}
	}
}
