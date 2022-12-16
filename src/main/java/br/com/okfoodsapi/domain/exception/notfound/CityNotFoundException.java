package br.com.okfoodsapi.domain.exception.notfound;

import br.com.okfoodsapi.domain.exception.RulesException;

public class CityNotFoundException extends RulesException {

	private static final long serialVersionUID = 1L;
	
	public CityNotFoundException(String message) {
		super(message);
	}
	
	public CityNotFoundException(Long cityId) {
		this(String.format("Não existe um City com o id %d", cityId));
	}
}
