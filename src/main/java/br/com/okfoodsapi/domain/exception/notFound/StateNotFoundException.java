package br.com.okfoodsapi.domain.exception.notFound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.okfoodsapi.domain.exception.RulesException;

@ResponseStatus(value = HttpStatus.NOT_FOUND) 
public class StateNotFoundException extends RulesException {

	private static final long serialVersionUID = 1L;
	
	public StateNotFoundException(String message) {
		super(message);
	}
	
	public StateNotFoundException(Long stateId) {
		this(String.format("Não existe um State com o id %d", stateId));
	}
}
