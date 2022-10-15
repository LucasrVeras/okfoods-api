package br.com.okfoodsapi.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.okfoodsapi.domain.exception.EntityInUseException;
import br.com.okfoodsapi.domain.exception.EntityNotFoundException;
import br.com.okfoodsapi.domain.models.Cuisine;
import br.com.okfoodsapi.domain.repositories.CuisineRepository;

@Service
public class CuisineRegistrationService {
	
	@Autowired
	private CuisineRepository cuisineRepository;
	
	public Cuisine add(Cuisine cuisine) {
		return cuisineRepository.save(cuisine);
	}
	
	public void remove(Long cuisineId) {
		
		try {
			cuisineRepository.deleteById(cuisineId);
		} catch(EmptyResultDataAccessException e) {
			throw new EntityNotFoundException(String.format("There is no cuisine "
								+ "registration with the code %d", cuisineId));
		} catch (DataIntegrityViolationException e) {
			throw new EntityInUseException(String.format("Cuisine cod %d cannot be "
								+ "removed, because it is in use", cuisineId));
		}
	}
}
