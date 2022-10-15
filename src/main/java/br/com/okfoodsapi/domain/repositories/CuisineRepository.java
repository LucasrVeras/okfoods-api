package br.com.okfoodsapi.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.okfoodsapi.domain.models.Cuisine;

@Repository
public interface CuisineRepository extends JpaRepository<Cuisine, Long> {
	
//	List<Cuisine> consultForName(String name);
	
	
	
}
