package br.com.okfoodsapi.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.okfoodsapi.domain.models.Cuisine;

@Repository
public interface CuisineRepository extends JpaRepository<Cuisine, Long> {
	
	List<Cuisine> name(String name);
		
}
