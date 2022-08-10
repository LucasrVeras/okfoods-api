package br.com.okfoodsapi.domain.repositories;

import java.util.List;

import br.com.okfoodsapi.domain.models.City;

public interface CityRepository {
	
	List<City> all();
	City searchForId(Long id);
	City add(City city);
	void remove(City city);
}
