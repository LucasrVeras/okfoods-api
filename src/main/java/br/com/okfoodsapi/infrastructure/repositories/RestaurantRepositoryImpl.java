package br.com.okfoodsapi.infrastructure.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.okfoodsapi.domain.models.Restaurant;
import br.com.okfoodsapi.domain.repositories.RestaurantRepository;

@Repository
public class RestaurantRepositoryImpl implements RestaurantRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Restaurant> all() {
		return manager.createQuery("from Restaurant", Restaurant.class)
				.getResultList();
	}
	
	@Override
	public Restaurant searchForId(Long id) {
		return manager.find(Restaurant.class, id);
	}
	
	@Transactional
	@Override
	public Restaurant add(Restaurant restaurant) {
		return manager.merge(restaurant);
	}
	
	@Transactional
	@Override
	public void remove(Long id) {
		searchForId(id);
		manager.remove(id);
	}
}
