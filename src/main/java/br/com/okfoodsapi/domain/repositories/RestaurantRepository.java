package br.com.okfoodsapi.domain.repositories;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.okfoodsapi.domain.models.Restaurant;

@Repository
public interface RestaurantRepository
		extends CustomJpaRepository<Restaurant, Long>,
			JpaSpecificationExecutor<Restaurant>,
			RestaurantRepositoryQueries{
	
    @Query("from Restaurant r join r.cuisine")
    List<Restaurant> findAll();
    
	List<Restaurant> queryByTaxShippingBetween(BigDecimal taxInit, BigDecimal taxEnd);
	
	List<Restaurant> consultByName(String name, @Param("id") long cuisineId);
	
	Optional<Restaurant> findFirstRestaurantByNameContaining(String name);
	
	List<Restaurant> findTop2ByNameContaining(String name);
	
	int countByCuisineId(Long cuisineId);
	
}
