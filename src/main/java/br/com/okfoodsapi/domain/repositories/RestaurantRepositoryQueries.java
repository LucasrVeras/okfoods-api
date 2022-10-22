package br.com.okfoodsapi.domain.repositories;

import java.math.BigDecimal;
import java.util.List;

import br.com.okfoodsapi.domain.models.Restaurant;

public interface RestaurantRepositoryQueries {
	
	List<Restaurant> find(String name, BigDecimal taxShippingInit,
			BigDecimal taxShippingEnd);

}
