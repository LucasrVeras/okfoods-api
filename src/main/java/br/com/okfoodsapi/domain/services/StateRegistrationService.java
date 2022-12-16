package br.com.okfoodsapi.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.okfoodsapi.domain.exception.EntityInUseException;
import br.com.okfoodsapi.domain.exception.notfound.StateNotFoundException;
import br.com.okfoodsapi.domain.models.State;
import br.com.okfoodsapi.domain.repositories.StateRepository;

@Service
public class StateRegistrationService {

  @Autowired
  private StateRepository stateRepository;
  
  private static final String MSG_STATE_CONFLICT = 
		  "State %d está em uso";

  public State add(State state) {
    return stateRepository.save(state);
  }

  public void remove(Long stateId) {
    try {
      stateRepository.deleteById(stateId);
    } catch (EmptyResultDataAccessException e) {
      searchOrFail(stateId);
    } catch (DataIntegrityViolationException e) {
      throw new EntityInUseException(String
          .format(MSG_STATE_CONFLICT, stateId));
    }
  }

  public State searchOrFail(Long stateId) {
    return stateRepository.findById(stateId).orElseThrow(() 
    		-> new StateNotFoundException(stateId));
  }
}
