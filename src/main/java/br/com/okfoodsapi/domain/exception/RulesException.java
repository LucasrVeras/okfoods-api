package br.com.okfoodsapi.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST) 
public class RulesException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public RulesException(String message) {
		super(message);
	}
	
	public RulesException(String message, Throwable cause) {
		super(message, cause);
	}
}
