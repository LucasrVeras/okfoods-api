package br.com.okfoodsapi.jpa.restaurant;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import br.com.okfoodsapi.OkfoodsApiApplication;
import br.com.okfoodsapi.domain.models.Restaurant;
import br.com.okfoodsapi.domain.repositories.RestaurantRepository;

public class RemoveRestaurantMain{
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = 
				new SpringApplicationBuilder(OkfoodsApiApplication.class)
					.web(WebApplicationType.NONE)
					.run(args);
		
		RestaurantRepository restaurantRepository = applicationContext
				.getBean(RestaurantRepository.class);
		
		var restaurants = new Restaurant();
		restaurants.setId(1L);
		
		restaurantRepository.remove(restaurants);
	}
}
