package br.com.okfoodsapi.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.okfoodsapi.domain.models.Cuisine;

@Component
public class CuisineRegistration {
	
	@PersistenceContext
	private EntityManager manager;
	
	public List<Cuisine> list(){
		return manager.createQuery("from Cuisine", Cuisine.class)
				.getResultList();
	}
	
	@Transactional
	public Cuisine addCuisine(Cuisine cuisine) {
		return manager.merge(cuisine);
	}
}
