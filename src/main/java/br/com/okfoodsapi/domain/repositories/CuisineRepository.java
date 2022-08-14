package br.com.okfoodsapi.domain.repositories;

import java.util.List;

import br.com.okfoodsapi.domain.models.Cuisine;

public interface CuisineRepository {
	
	List<Cuisine> all();
	Cuisine searchForId(Long id);
	Cuisine add(Cuisine cuisine);
	void remove(Long id);
}
