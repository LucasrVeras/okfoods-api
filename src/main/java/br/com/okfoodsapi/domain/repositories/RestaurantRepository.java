package br.com.okfoodsapi.domain.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.okfoodsapi.domain.models.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
	
	List<Restaurant> findByTaxShippingBetween(BigDecimal taxInit, BigDecimal taxEnd);
	
	List<Restaurant> findByNameContainingAndCuisineId(String name, long cuisineId);
}
