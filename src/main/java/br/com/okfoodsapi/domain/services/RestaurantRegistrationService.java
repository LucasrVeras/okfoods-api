package br.com.okfoodsapi.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.okfoodsapi.domain.exception.EntityInUseException;
import br.com.okfoodsapi.domain.exception.EntityNotFoundException;
import br.com.okfoodsapi.domain.models.Restaurant;
import br.com.okfoodsapi.domain.repositories.RestaurantRepository;

@Service
public class RestaurantRegistrationService {
	
	private static final String MSG_RESTAURANT_CONFLICT = 
			"Restaurant %d não pode ser removido porque está em uso";

	private static final String MSG_RESTAURANT_NOT_FOUND = 
			"Não há Restaurant com o id %d";

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	public Restaurant add(Restaurant restaurant) {
		 return restaurantRepository.save(restaurant);
	}
	
	public void remove(Long restaurantId) {
		try {
			restaurantRepository.deleteById(restaurantId);
		} catch (EmptyResultDataAccessException e) {
			searchOrFail(restaurantId);
		} catch (DataIntegrityViolationException e) {
			throw new EntityInUseException(String
					.format(MSG_RESTAURANT_CONFLICT, restaurantId));
		}
	}
	
	public Restaurant searchOrFail(Long restaurantId) {
		return restaurantRepository.findById(restaurantId).
				orElseThrow(() -> new EntityNotFoundException
						(String.format(MSG_RESTAURANT_NOT_FOUND, restaurantId)));
	}
}
