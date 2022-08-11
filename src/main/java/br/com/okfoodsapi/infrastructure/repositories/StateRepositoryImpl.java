package br.com.okfoodsapi.infrastructure.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import br.com.okfoodsapi.domain.models.State;
import br.com.okfoodsapi.domain.repositories.StateRepository;

@Component
public class StateRepositoryImpl implements StateRepository{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<State> all() {	
		return manager.createQuery("from State", State.class)
				.getResultList();
	}

	@Override
	public State searchForId(Long id) {
		return null;
	}

	@Override
	public State add(State state) {
		return null;
	}
	
	@Override
	public void remove(State state) {
		
	}
}
