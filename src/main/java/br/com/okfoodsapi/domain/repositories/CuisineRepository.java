package br.com.okfoodsapi.domain.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.okfoodsapi.domain.models.Cuisine;

@Repository
public interface CuisineRepository extends JpaRepository<Cuisine, Long> {
	
	// "Containing" para pesquisar usando like
	List<Cuisine> findByNameContaining(String name);
		
	Optional<Cuisine> findSingleByName(String name);
	
	boolean existsByName(String nome);
}
