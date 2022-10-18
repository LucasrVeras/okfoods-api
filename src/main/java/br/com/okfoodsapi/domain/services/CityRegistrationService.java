package br.com.okfoodsapi.domain.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.okfoodsapi.domain.exception.EntityNotFoundException;
import br.com.okfoodsapi.domain.models.City;
import br.com.okfoodsapi.domain.models.State;
import br.com.okfoodsapi.domain.repositories.CityRepository;
import br.com.okfoodsapi.domain.repositories.StateRepository;

@Service
public class CityRegistrationService {
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	public City add(City city) {
		
		Long cityId = city.getState().getId();
		Optional<State> state = stateRepository.findById(cityId);
		
		if (cityId == null) {
			throw new EntityNotFoundException(
					String.format("There is no cuisine registration "
							+ "with the code %d", cityId));
		} else {
			city.setState(state.get());
			return cityRepository.save(city);
		}
	}
	
	public void remove(Long cityId) {
		try {
			cityRepository.deleteById(cityId);
		} catch (EmptyResultDataAccessException e) {
			throw new  EntityNotFoundException(String.format("There is no state "
							+ "registration with the code %d", cityId));
		} catch (DataIntegrityViolationException e) {
			throw new EntityNotFoundException(String
					.format("Cuisine cod %d cannot be "
							+ "removed, because it is in use", cityId));
		}
	}
}
