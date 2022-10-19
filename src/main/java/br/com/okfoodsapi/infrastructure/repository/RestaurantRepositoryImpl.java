package br.com.okfoodsapi.infrastructure.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import br.com.okfoodsapi.domain.models.Restaurant;

@Repository
public class RestaurantRepositoryImpl {
	
	@PersistenceContext
	private EntityManager manager;
	
	public List<Restaurant> find(String name, BigDecimal taxShippingInit,
			BigDecimal taxShippingEnd){
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		
		CriteriaQuery<Restaurant> criteria = builder.createQuery(Restaurant.class);
		Root<Restaurant> root = criteria.from(Restaurant.class); //from Restaurant
		
		var predicates = new ArrayList<Predicate>();
		
		if (StringUtils.hasText(name)) {
			predicates.add(builder.like(root.get("name"), "%" + name + "%"));
		}
		
		if (taxShippingInit != null) {
			predicates.add(builder
					.greaterThanOrEqualTo(root.get("taxShipping"), taxShippingInit));
		}
		
		if (taxShippingEnd != null) {
			predicates
				.add(builder.lessThanOrEqualTo(root.get("taxShipping"), taxShippingEnd));
		}
		
		criteria.where(predicates.toArray(new Predicate[0]));
		
		TypedQuery<Restaurant> query = manager.createQuery(criteria);
		return query.getResultList();
	};
}
