package br.com.okfoodsapi.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.okfoodsapi.domain.exception.EntityInUseException;
import br.com.okfoodsapi.domain.exception.EntityNotFoundException;
import br.com.okfoodsapi.domain.models.State;
import br.com.okfoodsapi.domain.repositories.StateRepository;
import br.com.okfoodsapi.domain.services.StateRegistrationService;

@RestController
@RequestMapping("/states")
public class StateController {

	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private StateRegistrationService stateService;
	
	@GetMapping
	public List<State> list(){
		return stateRepository.findAll();
	}
	
	@GetMapping("/{statesId}")
	public ResponseEntity<State> searchForId(@PathVariable Long statesId){
		
		Optional<State> state = stateRepository.findById(statesId);
		
		if (state.isPresent()) {
			return ResponseEntity.ok(state.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<?> add(@RequestBody State state){
		try {
			state = stateService.add(state);
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(state);
		} catch (Exception e) {
			return ResponseEntity
					.badRequest()
					.body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{statesId}")
	public ResponseEntity<?> remove(@PathVariable Long statesId){
		try {
			stateService.remove(statesId);
			return ResponseEntity.noContent().build();
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (EntityInUseException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
}
