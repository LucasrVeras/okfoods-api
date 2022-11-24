package br.com.okfoodsapi.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		return cityRepository.findAll();
	}
	
	@GetMapping("/{cityId}")
	public City searchForId(@PathVariable Long cityId){
		return cityService.searchOrFail(cityId);
	}
	
	@PostMapping
	public City add(@RequestBody City cityId){
		return cityService.add(cityId);
	
	}
	
	@DeleteMapping("/{cityId}")
	public void remove(@PathVariable Long cityId){
		cityService.remove(cityId);
	}
}
