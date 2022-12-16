package br.com.okfoodsapi.api.controllers.exceptionhandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.okfoodsapi.domain.exception.EntityInUseException;
import br.com.okfoodsapi.domain.exception.RulesException;
import br.com.okfoodsapi.domain.exception.notfound.EntityNotFoundException;

@ControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> handleEntityNotFoundException(
			EntityNotFoundException e) {

		Problem problem = Problem
				.builder()
				.dataTime(LocalDateTime.now())
				.message(e.getMessage()).build();

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problem);
	}
	
	@ExceptionHandler(EntityInUseException.class)
	public ResponseEntity<?> handleConflictException(
			EntityInUseException e){
		
		Problem problem = Problem
				.builder()
				.dataTime(LocalDateTime.now())
				.message(e.getMessage()).build();
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(problem);
	}

	@ExceptionHandler(RulesException.class)
	public ResponseEntity<?> handleRulesException(
			RulesException e) {

		Problem problem = Problem
				.builder()
				.dataTime(LocalDateTime.now())
				.message(e.getMessage()).build();

		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(problem);
	}
	
	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public ResponseEntity<?> handleHttpMediaTypeNotSupportedException(
			HttpMediaTypeNotSupportedException e){
		
		Problem problem = Problem
				.builder()
				.dataTime(LocalDateTime.now())
				.message("O tipo de mídia não é suportado").build();
		
		return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
				.body(problem);
	}
}
