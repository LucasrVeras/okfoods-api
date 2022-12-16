package br.com.okfoodsapi.api.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.okfoodsapi.domain.exception.RulesException;
import br.com.okfoodsapi.domain.exception.notfound.StateNotFoundException;
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
	public State searchForId(@PathVariable Long statesId){
		return stateService.searchOrFail(statesId);
	}
	
	@PostMapping
	public State add(@RequestBody State state){
		try {
			return stateService.add(state);
		} catch (StateNotFoundException e) {
			throw new RulesException(e.getMessage(), e);
		}
	}
	
	@PutMapping("/{stateId}")
	public State update(@PathVariable Long stateId,
			@RequestBody State state) {
		
		try {
			State currentState = stateService.searchOrFail(stateId);
			BeanUtils.copyProperties(state, currentState, "id");
			
			return stateService.add(currentState);
		} catch (StateNotFoundException e) {
			throw new RulesException(e.getMessage(), e);
		}
	}
	
	@DeleteMapping("/{statesId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable Long statesId){
		stateService.remove(statesId);
	}	
}
