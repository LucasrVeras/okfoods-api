package br.com.okfoodsapi.infrastructure.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.okfoodsapi.domain.models.Restaurant;

@Repository
public class RestaurantRepositoryImpl {
	
	@PersistenceContext
	private EntityManager manager;
	
	public List<Restaurant> find(String name, BigDecimal taxShippingInit,
			BigDecimal taxShippingEnd){
		
		var jpql = "from Restaurant where name like :name "
				+ "and taxShipping between :taxShippingInit and :taxShippingEnd";
		
		return manager.createQuery(jpql, Restaurant.class)
				.setParameter("name", "%" + name + "%")
				.setParameter("taxShippingInit", taxShippingInit)
				.setParameter("taxShippingEnd", taxShippingEnd)
				.getResultList();
	};
}
