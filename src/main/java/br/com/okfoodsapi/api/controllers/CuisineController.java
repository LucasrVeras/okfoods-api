package br.com.okfoodsapi.api.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.okfoodsapi.domain.exception.EntityInUseException;
import br.com.okfoodsapi.domain.exception.EntityNotFoundException;
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
		return cuisineRepository.all();
	}
	
	@GetMapping("/{cuisineId}")
	public ResponseEntity<Cuisine> searchForId(@PathVariable Long cuisineId) {
		
		Cuisine cuisine = cuisineRepository.searchForId(cuisineId);
		
		if (cuisine != null) {
			return ResponseEntity.ok(cuisine);
		} else {
			return ResponseEntity.notFound().build();
		}	
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cuisine add(@RequestBody Cuisine cuisine) {
		return cuisineService.add(cuisine);
	}
	
	@PutMapping("/{cuisineId}")
	public ResponseEntity<Cuisine> update(@PathVariable Long cuisineId,
			@RequestBody Cuisine cuisine) {
		
		Cuisine cuisineCurrent = cuisineRepository.searchForId(cuisineId);
		
		if (cuisineCurrent != null) {
			BeanUtils.copyProperties(cuisine, cuisineCurrent, "id");
			cuisineService.add(cuisineCurrent);
			return ResponseEntity.ok(cuisineCurrent);
		}
			return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{CuiseneId}")
	public ResponseEntity<Cuisine> remove(@PathVariable Long CuiseneId){		
		try {
			cuisineService.remove(CuiseneId);
			return ResponseEntity.noContent().build();
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (EntityInUseException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
}
