package br.com.okfoodsapi.api.controllers;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.okfoodsapi.domain.exception.EntityNotFoundException;
import br.com.okfoodsapi.domain.models.Restaurant;
import br.com.okfoodsapi.domain.repositories.RestaurantRepository;
import br.com.okfoodsapi.domain.services.RestaurantRegistrationService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private RestaurantRegistrationService restaurantService;
	
	@GetMapping
	public List<Restaurant> list(){
	    return restaurantRepository.findAll();
	}
	
	@GetMapping("/{restaurantId}")
	public ResponseEntity<Restaurant> searchForId(@PathVariable Long restaurantId){
		
		Optional<Restaurant> restaurant = restaurantRepository
				.findById(restaurantId);
		
		if (restaurant != null) {
			return ResponseEntity.ok(restaurant.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<?> add(@RequestBody Restaurant restaurant){
		
		try {
			restaurant = restaurantService.add(restaurant);
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(restaurant);
		} catch (EntityNotFoundException e) {
			return ResponseEntity
					.badRequest()
					.body(e.getMessage());
		}
	}
	
    @PutMapping("/{restaurantId}")
	public ResponseEntity<?> update(@PathVariable Long restaurantId, 
			@RequestBody Restaurant restaurant){
		try {
			Restaurant currentRestaurant = restaurantRepository
			        .findById(restaurantId).orElse(null);
			if (currentRestaurant != null) {
			    BeanUtils.copyProperties(restaurant, currentRestaurant, 
			            "id", "methodsPayment", "address", 
			            "dateRegister", "products");
                currentRestaurant = restaurantService.add(currentRestaurant);  
                return ResponseEntity.ok(currentRestaurant);
            }
			 return ResponseEntity.notFound().build();
		}catch( EntityNotFoundException e) {
		    return ResponseEntity.badRequest().body(e.getMessage());
		}
   }

	@PatchMapping("/{restaurantId}")
	public ResponseEntity<?> updateHalf(@PathVariable Long restaurantId,
			@RequestBody Map<String , Object> fields){
		
		Optional <Restaurant> restaurantCurrent = restaurantRepository
				.findById(restaurantId);
		
		if (restaurantCurrent == null) {
			return ResponseEntity.notFound().build();
		}
		
		merge(fields, restaurantCurrent.get());
		
		return update(restaurantId, restaurantCurrent.get());
	}

	@SuppressWarnings("null")
    private void merge(Map<String, Object> fieldsOrigin, 
			Restaurant restaurantGoal) {
		
		var objectMapper =  new ObjectMapper();
		Restaurant restaurantOrigin = objectMapper
				.convertValue(fieldsOrigin, Restaurant.class);
		
		System.out.println(restaurantOrigin);
		
		fieldsOrigin.forEach((nameProperties, valueProperties) -> {	
			
			Field field = ReflectionUtils
					.findField(Restaurant.class, nameProperties);	
			field.setAccessible(true);
			
			Object newValue = ReflectionUtils.getField(field, restaurantOrigin);
			
			System.out.println(nameProperties + " = " 
					+ valueProperties + " = " 
					+ newValue);
			
			ReflectionUtils.setField(field, restaurantGoal, newValue);
		});
	}
}
