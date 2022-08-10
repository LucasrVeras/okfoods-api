package br.com.okfoodsapi.infrastructure.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import br.com.okfoodsapi.domain.models.City;
import br.com.okfoodsapi.domain.repositories.CityRepository;

@Component
public class CityRepositoryImpl implements CityRepository{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<City> all() {	
		return manager.createQuery("from City", City.class)
				.getResultList();
	}

	@Override
	public City searchForId(Long id) {
		
		return null;
	}

	@Override
	public City add(City city) {
		
		return null;
	}

	@Override
	public void remove(City city) {
		
		
	}

}
