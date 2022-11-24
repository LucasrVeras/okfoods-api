package br.com.okfoodsapi.domain.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.okfoodsapi.domain.exception.EntityInUseException;
import br.com.okfoodsapi.domain.exception.EntityNotFoundException;
import br.com.okfoodsapi.domain.models.City;
import br.com.okfoodsapi.domain.models.State;
import br.com.okfoodsapi.domain.repositories.CityRepository;
import br.com.okfoodsapi.domain.repositories.StateRepository;

@Service
public class CityRegistrationService {
	
	private static final String MSG_CITY_NOT_FOUND = 
			"Não existe City id %d ";
	
	private static final String MSG_CITY_CONFLICT = 
			"City id %d não pode ser removido, porque está em uso";

	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	public City add(City city) {
		
		Long cityId = city.getState().getId();
		Optional<State> state = stateRepository.findById(cityId);
		
		if (cityId == null) {
			throw new EntityNotFoundException(
					String.format(MSG_CITY_NOT_FOUND, cityId));
		} else {
			city.setState(state.get());
			return cityRepository.save(city);
		}
	}
	
	public void remove(Long cityId) {
		try {
			cityRepository.deleteById(cityId);
		} catch (EmptyResultDataAccessException e) {
			searchOrFail(cityId);
		} catch (DataIntegrityViolationException e) {
			throw new EntityInUseException(String
					.format(MSG_CITY_CONFLICT, cityId));
		}
	}
	
	public City searchOrFail(Long cityId) {
		return cityRepository.findById(cityId)
				.orElseThrow(() -> new EntityNotFoundException(
						String.format(MSG_CITY_NOT_FOUND, cityId)));
	}
}
