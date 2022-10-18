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
	
	@GetMapping("/restaurants/find-tax-shipping-between")
	public List<Restaurant> findByTaxShippingBetween(
			BigDecimal taxInit, BigDecimal taxEnd){
		
		return restaurantRepository.findByTaxShippingBetween(taxInit, taxEnd);
	}
	
	@GetMapping("/restaurants/for-name")
	public List<Restaurant> restaurantsForName(String name, Long cuisineId){
		return restaurantRepository.findByNameContainingAndCuisineId(name, cuisineId);
	}
}
