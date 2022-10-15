package br.com.okfoodsapi.domain.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.okfoodsapi.domain.exception.EntityInUseException;
import br.com.okfoodsapi.domain.exception.EntityNotFoundException;
import br.com.okfoodsapi.domain.models.Cuisine;
import br.com.okfoodsapi.domain.models.Restaurant;
import br.com.okfoodsapi.domain.repositories.CuisineRepository;
import br.com.okfoodsapi.domain.repositories.RestaurantRepository;

@Service
public class RestaurantRegistrationService {
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private CuisineRepository cuisineRepository;
	
	public Restaurant add(Restaurant restaurant) {
		
		Long cuisineId = restaurant.getCuisine().getId();
		Optional<Cuisine> cuisine = cuisineRepository.findById(cuisineId);
		
		if (cuisine.isEmpty()) {
			throw new EntityNotFoundException(
					String.format("There is no cuisine registration "
							+ "with the code %d", cuisineId));
		}else {
			restaurant.setCuisine(cuisine.get());
			return restaurantRepository.save(restaurant);
		}
	}
	
	public void remove(Long restaurantId) {
		try {
			restaurantRepository.deleteById(restaurantId);
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException(String.format("There is no restauran"
					+ " registration with the code %d", restaurantId));
		} catch (DataIntegrityViolationException e) {
			throw new EntityInUseException(String.format("Cuisine cod %d cannot be "
					+ "removed, because it is in use", restaurantId));
		}
	}
}
