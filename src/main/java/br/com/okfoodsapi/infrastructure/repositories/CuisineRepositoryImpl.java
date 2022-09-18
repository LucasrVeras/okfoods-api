package br.com.okfoodsapi.infrastructure.repositories;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.okfoodsapi.domain.models.Cuisine;
import br.com.okfoodsapi.domain.repositories.CuisineRepository;

@Repository
public class CuisineRepositoryImpl implements CuisineRepository {

	
	private EntityManager manager;
	
	@Override
	public Cuisine searchForId(Long cuisineId) {
		return manager.find(Cuisine.class, cuisineId);
	}
	
	@Override
	public List<Cuisine> all(){
		return manager.createQuery("from Cuisine", Cuisine.class)
				.getResultList();
	}
	
	@Override
	public List<Cuisine> consultForName(String name) {
		return manager.createQuery("from Cuisine where name = :name", Cuisine.class)
				.setParameter("name", name)
				.getResultList();
	}
	
	@Transactional
	@Override
	public Cuisine add(Cuisine cuisine) {
		return manager.merge(cuisine);
	}
	
	@Transactional
	@Override
	public void remove(Long id) {
		
		Cuisine cuisine = searchForId(id);
		
		if (cuisine == null) {
			throw new EmptyResultDataAccessException(1);
		} 
		
		manager.remove(cuisine);
	}
}
