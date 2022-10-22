package br.com.okfoodsapi.api.controllers;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.okfoodsapi.domain.models.Cuisine;
import br.com.okfoodsapi.domain.models.Restaurant;
import br.com.okfoodsapi.domain.repositories.CuisineRepository;
import br.com.okfoodsapi.domain.repositories.RestaurantRepository;
import br.com.okfoodsapi.infrastructure.repository.spec.RestaurantNameSimilarSpec;
import br.com.okfoodsapi.infrastructure.repository.spec.RestaurantWithFreeShippingSpec;

@RestController
@RequestMapping("/teste")
public class TesteController {
	
	@Autowired
	private CuisineRepository cuisineRepository;
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@GetMapping("/cuisines/for-name")
	public List<Cuisine> cuisineForName(@RequestParam("name") String name){
		return cuisineRepository.findByNameContaining(name);
	}
	
	@GetMapping("/cuisines/for-name-single")
	public Optional<Cuisine> cuisineSingleByName(String name){
		return cuisineRepository.findSingleByName(name);
	}
	
	@GetMapping("/cuisines/exists")
	public boolean existsName(String name){
		return cuisineRepository.existsByName(name);
	}
	
	@GetMapping("/restaurants/find-tax-shipping-between")
	public List<Restaurant> findByTaxShippingBetween(
			BigDecimal taxInit, BigDecimal taxEnd){
		
		return restaurantRepository.queryByTaxShippingBetween(taxInit, taxEnd);
	}
	
	@GetMapping("/restaurants/for-name")
	public List<Restaurant> restaurantsForName(String name, Long cuisineId){
		return restaurantRepository.consultByName(name, cuisineId);
	}
	
	@GetMapping("/restaurants/frist")
	public Optional<Restaurant> firstRestaurantsName(String name){
		return restaurantRepository.findFirstRestaurantByNameContaining(name);
	}
	
	@GetMapping("/restaurants/top")
	public List<Restaurant> findTop (String name){
		return restaurantRepository.findTop2ByNameContaining(name);
	}
	
	@GetMapping("/restaurants/for-name-shipping")
	public List<Restaurant> restaurantsByShipping(String name,
			BigDecimal taxShippingInit, BigDecimal taxShippingEnd){
		
		return restaurantRepository
				.find(name, taxShippingInit, taxShippingEnd);
	}
	
	@GetMapping("/restaurants/count")
	public int countCuisine (Long cuisineId){
		return restaurantRepository.countByCuisineId(cuisineId);
	}
	
	@GetMapping("/restaurants/free-shipping")
	public List<Restaurant> restaurantsWithFreeShipping(String name){
		
		var withFreeShipping = new RestaurantWithFreeShippingSpec();
		var withNameSimilar =  new RestaurantNameSimilarSpec(name);

		return restaurantRepository.findAll(withFreeShipping.and(withNameSimilar));
	}
}
