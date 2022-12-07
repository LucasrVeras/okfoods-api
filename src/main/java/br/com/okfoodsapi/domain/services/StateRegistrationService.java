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

  private static final String MSG_STATE_NOT_FOUND = 
		  "Não há State com o id %d";

  private static final String MSG_STATE_CONFLICT = 
		  "State %d não pode ser removido porque está em uso";

  @Autowired
  private StateRepository stateRepository;

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
    		-> new EntityNotFoundException(
        String.format(MSG_STATE_NOT_FOUND, stateId)));
  }
}
