package br.com.okfoodsapi.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.server.ResponseStatusException;

//@ResponseStatus(value = HttpStatus.CONFLICT)
public class EntityInUseException extends ResponseStatusException {

	private static final long serialVersionUID = 1L;
	
	public EntityInUseException(HttpStatus status, @Nullable String reason) {
		super(status, reason);
	}

	public EntityInUseException(String reason) {
	     this(HttpStatus.CONFLICT, reason);
	}
}
