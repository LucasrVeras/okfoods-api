package br.com.okfoodsapi.api.controllers;

import java.util.List;

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
import br.com.okfoodsapi.domain.models.City;
import br.com.okfoodsapi.domain.repositories.CityRepository;
import br.com.okfoodsapi.domain.services.CityRegistrationService;

@RestController
@RequestMapping("/citys")
public class CityController {
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private CityRegistrationService cityService;
	
	@GetMapping
	public List<City> list() {
		return cityRepository.all();
	}
	
	@GetMapping("/{cityId}")
	public ResponseEntity<City> searchForId(@PathVariable Long cityId){
		
		City city = cityRepository.searchForId(cityId);
		
		if (city != null) {
			return ResponseEntity.ok(city);
		}else {
			return ResponseEntity.notFound().build();
			
		}
	}
	
	@PostMapping
	public ResponseEntity<?> add(@RequestBody City city){
		
		try {
			city = cityService.add(city);
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(city);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.badRequest()
					.body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{cityId}")
	public ResponseEntity<?> remove(@PathVariable Long cityId){
		try {
			cityService.remove(cityId);
			return ResponseEntity.noContent().build();
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (EntityInUseException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
}
