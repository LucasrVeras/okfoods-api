package br.com.okfoodsapi.api.controllers;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.okfoodsapi.domain.exception.RulesException;
import br.com.okfoodsapi.domain.exception.notFound.EntityNotFoundException;
import br.com.okfoodsapi.domain.models.Restaurant;
import br.com.okfoodsapi.domain.repositories.RestaurantRepository;
import br.com.okfoodsapi.domain.services.RestaurantRegistrationService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

  @Autowired
  private RestaurantRepository restaurantRepository;

  @Autowired
  private RestaurantRegistrationService restaurantService;

  @GetMapping
  public List<Restaurant> list() {
    return restaurantRepository.findAll();
  }

  @GetMapping("/{restaurantId}")
  public Restaurant searchForId(@PathVariable Long restaurantId) {
    return restaurantService.searchOrFail(restaurantId);
  }

  @PostMapping
  public Restaurant add(@RequestBody Restaurant restaurant) {
    try {
      return restaurantService.add(restaurant);
    } catch (EntityNotFoundException e) {
      throw new RulesException(e.getMessage(), e);
    }
  }

  @PutMapping("/{restaurantId}")
  @ResponseStatus(HttpStatus.CREATED)
  public Restaurant update(@PathVariable Long restaurantId,
      @RequestBody Restaurant restaurant) {

    Restaurant currentRestaurant = restaurantService.searchOrFail(restaurantId);

    BeanUtils.copyProperties(restaurant, currentRestaurant,
        "id", "methodsPayment", "address",
        "dateRegister", "products");

    try {
      return restaurantService.add(currentRestaurant);
    } catch (EntityNotFoundException e) {
      throw new RulesException(e.getMessage(), e);
    }
  }

  @PatchMapping("/{restaurantId}")
  public Restaurant updateHalf(@PathVariable Long restaurantId,
      @RequestBody Map<String, Object> fields) {

    Restaurant restaurantCurrent = restaurantService.searchOrFail(restaurantId);

    merge(fields, restaurantCurrent);

    return update(restaurantId, restaurantCurrent);
  }

  @SuppressWarnings("null")
  private void merge(Map<String, Object> fieldsOrigin,
      Restaurant restaurantGoal) {

    var objectMapper = new ObjectMapper();
    Restaurant restaurantOrigin = objectMapper
        .convertValue(fieldsOrigin, Restaurant.class);

    fieldsOrigin.forEach((nameProperties, valueProperties) -> {
      Field field = ReflectionUtils
          .findField(Restaurant.class, nameProperties);
      field.setAccessible(true);

      Object newValue = ReflectionUtils.getField(field, restaurantOrigin);

      ReflectionUtils.setField(field, restaurantGoal, newValue);
    });
  }
}
