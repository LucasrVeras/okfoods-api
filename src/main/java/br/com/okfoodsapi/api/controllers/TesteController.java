package br.com.okfoodsapi.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.okfoodsapi.domain.models.Cuisine;
import br.com.okfoodsapi.domain.repositories.CuisineRepository;

@RestController
@RequestMapping("/teste")
public class TesteController {
	
	@Autowired
	private CuisineRepository cuisineRepository;
	
	@GetMapping("/cuisines/for-name")
	public List<Cuisine> cuisineForName(@RequestParam("name") String name){
		return cuisineRepository.name(name);
	}
}
