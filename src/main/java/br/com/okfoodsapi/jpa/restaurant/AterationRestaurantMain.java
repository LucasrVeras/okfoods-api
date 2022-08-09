package br.com.okfoodsapi.jpa.restaurant;

import java.math.BigDecimal;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import br.com.okfoodsapi.OkfoodsApiApplication;
import br.com.okfoodsapi.domain.models.Restaurant;
import br.com.okfoodsapi.domain.repositories.RestaurantRepository;

public class AterationRestaurantMain{
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = 
				new SpringApplicationBuilder(OkfoodsApiApplication.class)
					.web(WebApplicationType.NONE)
					.run(args);
		
		RestaurantRepository restaurantRepository = applicationContext
				.getBean(RestaurantRepository.class);
		
		var restaurant = new Restaurant();
		restaurant.setId(1L);
		restaurant.setName("Thai Foods");
		restaurant.setTaxShipping(new BigDecimal(7.50));
		
		restaurantRepository.add(restaurant);
		
	}
}
