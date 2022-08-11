package br.com.okfoodsapi.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.okfoodsapi.api.model.CuisinesXmlWrapper;
import br.com.okfoodsapi.domain.models.Cuisine;
import br.com.okfoodsapi.domain.repositories.CuisineRepository;

@RestController
@RequestMapping("/cuisines")
public class CuisineController {
	
	@Autowired
	private CuisineRepository cuisineRepository;
	
	@GetMapping
	public List<Cuisine> list(){
		return cuisineRepository.all();
	}
	
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public CuisinesXmlWrapper listXml(){
		return new CuisinesXmlWrapper(cuisineRepository.all());
	}
	
	@GetMapping("/{cuisineId}")
	public Cuisine searchForId(@PathVariable Long cuisineId) {
		return cuisineRepository.searchForId(cuisineId);
	}
}
