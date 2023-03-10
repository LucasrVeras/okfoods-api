package br.com.okfoodsapi.domain.repositories;

import java.util.List;
import java.util.Optional;

import br.com.okfoodsapi.domain.models.Cuisine;

public interface CuisineRepository extends CustomJpaRepository<Cuisine, Long> {
	
	// "Containing" para pesquisar usando like
	List<Cuisine> findByNameContaining(String name);
		
	Optional<Cuisine> findSingleByName(String name);
	
	boolean existsByName(String nome);
}
