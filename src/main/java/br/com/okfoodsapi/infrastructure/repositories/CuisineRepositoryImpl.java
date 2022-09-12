package br.com.okfoodsapi.infrastructure.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.okfoodsapi.domain.models.Cuisine;
import br.com.okfoodsapi.domain.repositories.CuisineRepository;

@Repository
public class CuisineRepositoryImpl implements CuisineRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Cuisine> all(){
		return manager.createQuery("from Cuisine", Cuisine.class)
				.getResultList();
	}
	
	@Override
	public Cuisine searchForId(Long id) {
		return manager.find(Cuisine.class, id);
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
