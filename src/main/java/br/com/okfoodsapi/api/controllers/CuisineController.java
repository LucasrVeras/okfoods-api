package br.com.okfoodsapi.api.controllers;

import java.util.List;
import java.util.Optional;

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
		return cuisineRepository.findAll();
	}
	
	@GetMapping("/{cuisineId}")
	public ResponseEntity<Cuisine> searchForId(@PathVariable Long cuisineId) {
		
		Optional<Cuisine> cuisine = cuisineRepository.findById(cuisineId);
		
		if (cuisine.isPresent()) {
			return ResponseEntity.ok(cuisine.get());
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
	public ResponseEntity<?> update(@PathVariable Long cuisineId,
			@RequestBody Cuisine cuisine) { 
	    try {  
	        Cuisine currentCuisine = cuisineRepository
	                .findById(cuisineId).orElse(null);
	        if (currentCuisine != null) {
                BeanUtils.copyProperties(cuisine, currentCuisine, "id");
                currentCuisine = cuisineService.add(currentCuisine);
                return ResponseEntity.ok(currentCuisine);
            }  
	        return ResponseEntity.notFound().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
	}

	@DeleteMapping("/{cuisineId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable Long cuisineId){	
			cuisineService.remove(cuisineId);
	} 
}
	