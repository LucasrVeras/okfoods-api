package br.com.okfoodsapi.domain.repositories;

import java.util.List;

import br.com.okfoodsapi.domain.models.Restaurant;

public interface RestaurantRepository {
	
	List<Restaurant> all();
	Restaurant searchForId(Long id);
	Restaurant add(Restaurant restaurant);
	void remove(Long id);
}
