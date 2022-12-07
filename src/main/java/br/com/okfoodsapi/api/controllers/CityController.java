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

import br.com.okfoodsapi.domain.exception.EntityNotFoundException;
import br.com.okfoodsapi.domain.exception.RulesException;
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
    return cityService.searchOrFail(cityId);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public City add(@RequestBody City cityId) {
    return cityService.add(cityId);

  }

  @PutMapping("/{cityId}")
  public City update(@PathVariable Long cityId,
      @RequestBody City city) {

    City currentCity = cityService.searchOrFail(cityId);
    BeanUtils.copyProperties(city, currentCity, "id");

    try {
      return cityService.add(currentCity);
    } catch (EntityNotFoundException e) {
      throw new RulesException(e.getMessage());
    }
  }

  @DeleteMapping("/{cityId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void remove(@PathVariable Long cityId) {
    cityService.remove(cityId);
  }
}
