package br.com.okfoodsapi.domain.repositories;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.okfoodsapi.domain.models.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
	
	List<Restaurant> queryByTaxShippingBetween(BigDecimal taxInit, BigDecimal taxEnd);
	
//	@Query("from Restaurant where name like %:name% and cuisine.id = :id")
	List<Restaurant> consultByName(String name, @Param("id") long cuisineId);
	
//	List<Restaurant> findByNameContainingAndCuisineId(String name, long cuisineId);
	
	Optional<Restaurant> findFirstRestaurantByNameContaining(String name);
	
	List<Restaurant> findTop2ByNameContaining(String name);
	
	int countByCuisineId(Long cuisineId);
}
