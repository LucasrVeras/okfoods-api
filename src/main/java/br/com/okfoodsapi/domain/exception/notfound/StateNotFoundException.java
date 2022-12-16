package br.com.okfoodsapi.domain.exception.notfound;

import br.com.okfoodsapi.domain.exception.RulesException;

public class StateNotFoundException extends RulesException {

	private static final long serialVersionUID = 1L;
	
	public StateNotFoundException(String message) {
		super(message);
	}
	
	public StateNotFoundException(Long stateId) {
		this(String.format("Não existe um State com o id %d", stateId));
	}
}
