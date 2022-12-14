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
import br.com.okfoodsapi.domain.exception.notfound.CuisineNotFoundException;
import br.com.okfoodsapi.domain.models.Cuisine;
import br.com.okfoodsapi.domain.repositories.CuisineRepository;
import br.com.okfoodsapi.domain.services.CuisineRegistrationService;

@RestController
@RequestMapping("/cuisines")
public class CuisineController {
	
	@Autowired
	private CuisineRepository cuisineRepository;
	
	@Autowired
	private CuisineRegistrationService cuisineService;
	
	@GetMapping
	public List<Cuisine> list(){
		return cuisineRepository.findAll();
	}
	
	@GetMapping("/{cuisineId}")
	public Cuisine searchForId(@PathVariable Long cuisineId) {
		return cuisineService.searchOrFail(cuisineId);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cuisine add(@RequestBody Cuisine cuisine) {
		try {
			return cuisineService.add(cuisine);
		} catch (CuisineNotFoundException e) {
			throw new RulesException(e.getMessage(), e);
		}
	}
	
	@PutMapping("/{cuisineId}")
	public Cuisine update(@PathVariable Long cuisineId,
			@RequestBody Cuisine cuisine) { 
		
		try {
			Cuisine currentCuisine = cuisineService.searchOrFail(cuisineId);
			BeanUtils.copyProperties(cuisine, currentCuisine, "id");
			
			return cuisineService.add(currentCuisine);
		} catch (CuisineNotFoundException e) {
			throw new RulesException(e.getMessage(), e);
		}
	}

	@DeleteMapping("/{cuisineId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable Long cuisineId){	
			cuisineService.remove(cuisineId);
	} 
}
	