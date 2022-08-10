package br.com.okfoodsapi.jpa.restaurant;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import br.com.okfoodsapi.OkfoodsApiApplication;
import br.com.okfoodsapi.domain.models.Restaurant;
import br.com.okfoodsapi.domain.repositories.RestaurantRepository;

public class QueryRestaurantMain{
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = 
				new SpringApplicationBuilder(OkfoodsApiApplication.class)
					.web(WebApplicationType.NONE)
					.run(args);
		
		RestaurantRepository restaurantRepository = applicationContext
				.getBean(RestaurantRepository.class);
		
		List<Restaurant> allRestaurants = restaurantRepository.all();
		
		for (Restaurant restaurant : allRestaurants) {
			System.out.printf("%s - %f - %s \n", restaurant.getName(),
					restaurant.getTaxShipping(), restaurant.getCuisine().getName());
		}
	}
}
