package br.com.okfoodsapi.api.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import br.com.okfoodsapi.api.model.CuisinesXmlWrapper;
import br.com.okfoodsapi.domain.exception.EntityInUseException;
import br.com.okfoodsapi.domain.exception.EntityNotFoundException;
import br.com.okfoodsapi.domain.models.Cuisine;
import br.com.okfoodsapi.domain.repositories.CuisineRepository;
import br.com.okfoodsapi.domain.service.CuisineRegistrationService;

@RestController
@RequestMapping("/cuisines")
public class CuisineController {
	
	@Autowired
	private CuisineRepository cuisineRepository;
	
	@Autowired
	private CuisineRegistrationService cuisineRegistration;
	
	@GetMapping
	public List<Cuisine> list(){
		return cuisineRepository.all();
	}
	
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public CuisinesXmlWrapper listXml(){
		return new CuisinesXmlWrapper(cuisineRepository.all());
	}
	
	@GetMapping("/{cuisineId}")
	public ResponseEntity<Cuisine> searchForId(@PathVariable Long cuisineId) {
		
		Cuisine cuisine = cuisineRepository.searchForId(cuisineId);
		
//		var headers = new HttpHeaders();
//		headers.add(HttpHeaders.LOCATION, "htpp://api.okfoods.local:5000/cuisines");
//		
//		return ResponseEntity
//				.status(HttpStatus.FOUND)
//				.headers(headers)
//				.build();
	
		if (cuisine != null) {
			return ResponseEntity.ok(cuisine);
		} else {
			return ResponseEntity.notFound().build();
		}	
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cuisine add(@RequestBody Cuisine cuisine) {
		return cuisineRegistration.add(cuisine);
	}
	
	@PutMapping("/{cuisineId}")
	public ResponseEntity<Cuisine> update(@PathVariable Long cuisineId,
			@RequestBody Cuisine cuisine) {
		
		Cuisine cuisineCurrent = cuisineRepository.searchForId(cuisineId);
		
		if (cuisineCurrent != null) {
			BeanUtils.copyProperties(cuisine, cuisineCurrent, "id");
			cuisineRepository.add(cuisineCurrent);
			return ResponseEntity.ok(cuisineCurrent);
		}
			return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{CuiseneId}")
	public ResponseEntity<Cuisine> remove(@PathVariable Long CuiseneId){		
		try {
			cuisineRegistration.remove(CuiseneId);
			return ResponseEntity.noContent().build();
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (EntityInUseException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
}
