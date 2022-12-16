package br.com.okfoodsapi.domain.exception.notfound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.okfoodsapi.domain.exception.RulesException;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CityNotFoundException extends RulesException {

	private static final long serialVersionUID = 1L;
	
	public CityNotFoundException(String message) {
		super(message);
	}
	
	public CityNotFoundException(Long cityId) {
		this(String.format("Não existe um City com o id %d", cityId));
	}
}
