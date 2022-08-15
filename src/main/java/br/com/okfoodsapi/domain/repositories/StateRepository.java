package br.com.okfoodsapi.domain.repositories;

import java.util.List;

import br.com.okfoodsapi.domain.models.State;

public interface StateRepository {
	
	List<State> all();
	State searchForId(Long id);
	State add(State state);
	void remove(Long id);
}
