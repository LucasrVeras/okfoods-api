package br.com.okfoodsapi.infrastructure.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import br.com.okfoodsapi.domain.models.State;
import br.com.okfoodsapi.domain.repositories.StateRepository;

@Repository
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
		return manager.find(State.class, id);
	}
	
	@Transactional
	@Override
	public State add(State state) {
		return manager.merge(state);
	}
	
	@Transactional
	@Override
	public void remove(Long id) {
		
		State state = searchForId(id) ;
		
		if (state == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		manager.remove(state);
	}
}
