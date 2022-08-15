package br.com.okfoodsapi.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.okfoodsapi.domain.exception.EntityInUseException;
import br.com.okfoodsapi.domain.exception.EntityNotFoundException;
import br.com.okfoodsapi.domain.models.State;
import br.com.okfoodsapi.domain.repositories.StateRepository;

@Service
public class StateRegistrationService {
	
	@Autowired
	private StateRepository stateRepository;
	
	public State add(State state) {
		return stateRepository.add(state);
	}
	
	public void remove(Long stateId) {
		try {
			stateRepository.remove(stateId);
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException(String
					.format("There is no state"
							+ "registration with the code %d", stateId));
		} catch (DataIntegrityViolationException e) {
			throw new EntityInUseException(String
					.format("Cuisine cod %d cannot be"
							+ "removed, because it is in use", stateId));
		}
	}
}
