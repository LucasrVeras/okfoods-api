package br.com.okfoodsapi.api.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.okfoodsapi.api.controllers.exceptionhandler.Problem;
import br.com.okfoodsapi.domain.exception.RulesException;
import br.com.okfoodsapi.domain.exception.notfound.CityNotFoundException;
import br.com.okfoodsapi.domain.exception.notfound.EntityNotFoundException;
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
	public City searchForId(@PathVariable Long cityId) {
		try {
			return cityService.searchOrFail(cityId);
		} catch (CityNotFoundException e) {
			throw new RulesException(e.getMessage(), e);
		}
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public City add(@RequestBody City cityId) {
		try {
			return cityService.add(cityId);
		} catch (CityNotFoundException e) {
			throw new RulesException(e.getMessage(), e);
		}
	}

	@PutMapping("/{cityId}")
	public City update(@PathVariable Long cityId, @RequestBody City city) {
		try {

			City currentCity = cityService.searchOrFail(cityId);
			BeanUtils.copyProperties(city, currentCity, "id");

			return cityService.add(currentCity);
		} catch (CityNotFoundException e) {
			throw new RulesException(e.getMessage(), e);
		}
	}

	@DeleteMapping("/{cityId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable Long cityId) {
		cityService.remove(cityId);
	}

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> handleEntityNotFoundException(
			EntityNotFoundException e) {
		
		Problem problem = Problem.builder()
				.dataTime(LocalDateTime.now())
				.message(e.getMessage()).build();
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(problem);
	}
	
	@ExceptionHandler(RulesException.class)
	public ResponseEntity<?> handleRulesException(
			RulesException e) {
		
		Problem problem = Problem.builder()
				.dataTime(LocalDateTime.now())
				.message(e.getMessage()).build();
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(problem);
	}
}
