package br.com.okfoodsapi.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.okfoodsapi.domain.models.Restaurant;
import br.com.okfoodsapi.domain.repositories.RestaurantRepository;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@GetMapping
	public List<Restaurant> list(){
		return restaurantRepository.all();
	}
	
	@GetMapping("/{restaurantId}")
	public ResponseEntity<Restaurant> searchForId(@PathVariable Long restaurantId){
		
		Restaurant restaurant = restaurantRepository.searchForId(restaurantId);
		
		if (restaurant != null) {
			return ResponseEntity.ok(restaurant);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
