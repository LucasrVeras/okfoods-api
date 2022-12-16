package br.com.okfoodsapi.domain.exception.notfound;

import br.com.okfoodsapi.domain.exception.RulesException;

public class CuisineNotFoundException extends RulesException {
		
	private static final long serialVersionUID = 1L;
	
	public CuisineNotFoundException(String message) {
		super(message);
	}
	
	public CuisineNotFoundException(Long cuisineId) {
		this(String.format("Não existe um Cuisine com o id %d", cuisineId));
	}
}
