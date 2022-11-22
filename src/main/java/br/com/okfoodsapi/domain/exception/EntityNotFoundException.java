package br.com.okfoodsapi.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.server.ResponseStatusException;

//@ResponseStatus(value = HttpStatus.NOT_FOUND) 
//	reason = "Entidade não encontrada!")
public class EntityNotFoundException extends ResponseStatusException {

	private static final long serialVersionUID = 1L;

	public EntityNotFoundException(HttpStatus status, @Nullable String reason) {
		super(status, reason);
		
	}
	
	public EntityNotFoundException(String reason) {
		this(HttpStatus.NOT_FOUND, reason);
	}
}
