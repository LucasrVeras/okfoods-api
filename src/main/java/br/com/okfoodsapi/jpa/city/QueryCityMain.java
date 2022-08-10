package br.com.okfoodsapi.jpa.city;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import br.com.okfoodsapi.OkfoodsApiApplication;
import br.com.okfoodsapi.domain.models.City;
import br.com.okfoodsapi.domain.repositories.CityRepository;

public class QueryCityMain{
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = 
				new SpringApplicationBuilder(OkfoodsApiApplication.class)
					.web(WebApplicationType.NONE)
					.run(args);
		
		CityRepository cityRepository = applicationContext
				.getBean(CityRepository.class);
	
		List<City> allCity = cityRepository.all();
		
		for (City city : allCity) {
			System.out.printf("%s - %s \n", city.getName(),
					city.getState().getName());
		}
	}
}
