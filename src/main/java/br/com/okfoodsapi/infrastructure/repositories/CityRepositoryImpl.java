package br.com.okfoodsapi.infrastructure.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import br.com.okfoodsapi.domain.models.City;
import br.com.okfoodsapi.domain.repositories.CityRepository;

@Repository
public class CityRepositoryImpl implements CityRepository{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<City> all() {	
		return manager.createQuery("from City", City.class)
				.getResultList();
	}

	@Override
	public City searchForId(Long cityId) {
		return manager.find(City.class, cityId);
	}

	@Override
	@Transactional
	public City add(City city) {
		return manager.merge(city);
	}

	@Override
	@Transactional
	public void remove(Long cityId) {
		
		City city = searchForId(cityId);
		
		if (city == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		manager.remove(city);
	}
}
