package br.com.okfoodsapi.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.okfoodsapi.domain.models.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
	
}
