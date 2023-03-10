package br.com.okfoodsapi.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.okfoodsapi.domain.models.State;

public interface StateRepository extends JpaRepository<State, Long> {
	
}
