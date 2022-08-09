package br.com.okfoodsapi.jpa.restaurant;

import java.math.BigDecimal;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import br.com.okfoodsapi.OkfoodsApiApplication;
import br.com.okfoodsapi.domain.models.Restaurant;
import br.com.okfoodsapi.domain.repositories.RestaurantRepository;

public class RegistrationRestaurantMain{
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = 
				new SpringApplicationBuilder(OkfoodsApiApplication.class)
					.web(WebApplicationType.NONE)
					.run(args);
		
		RestaurantRepository restaurantRepository = applicationContext
				.getBean(RestaurantRepository.class);
		
		var restaurant1 = new Restaurant();
		restaurant1.setName("Churrascaria Gaucho");
		restaurant1.setTaxShipping(new BigDecimal(2.5));
		
		var restaurant2 = new Restaurant();
		restaurant2.setName("Sushi Tengu");
		restaurant2.setTaxShipping(new BigDecimal(5.0));
		
		restaurantRepository.add(restaurant1);
		restaurantRepository.add(restaurant2);
	}
}
