package br.com.okfoodsapi.domain.exception.notfound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.okfoodsapi.domain.exception.RulesException;

@ResponseStatus(value = HttpStatus.NOT_FOUND) 
public class RestaurantNotFoundException extends RulesException {
	
	private static final long serialVersionUID = 1L;

	public RestaurantNotFoundException(String message) {
		super(message);
	}

	public RestaurantNotFoundException(Long restaurantId) {
		this(String.format("Não existe um Restaurant com o id %d", restaurantId));
	}
}
