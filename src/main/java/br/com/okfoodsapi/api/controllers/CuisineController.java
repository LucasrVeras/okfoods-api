package br.com.okfoodsapi.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.okfoodsapi.domain.models.Cuisine;
import br.com.okfoodsapi.domain.repositories.CuisineRepository;

@RestController
@RequestMapping(value = "/cuisines", produces = MediaType.APPLICATION_JSON_VALUE )
public class CuisineController {
	
	@Autowired
	private CuisineRepository cuisineRepository;
	
	@GetMapping
	public List<Cuisine> list(){
		return cuisineRepository.all();
	}
}
