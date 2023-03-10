package br.com.okfoodsapi.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.okfoodsapi.domain.models.City;

public interface CityRepository extends JpaRepository<City, Long>{
}
