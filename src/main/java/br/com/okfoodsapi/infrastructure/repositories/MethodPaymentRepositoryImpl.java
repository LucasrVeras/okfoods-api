package br.com.okfoodsapi.infrastructure.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import br.com.okfoodsapi.domain.models.MethodPayment;
import br.com.okfoodsapi.domain.repositories.MethodPaymentRepository;

@Component
public class MethodPaymentRepositoryImpl implements MethodPaymentRepository{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<MethodPayment> all() {	
		return manager.createQuery("from MethodPayment", MethodPayment.class)
				.getResultList();
	}

	@Override
	public MethodPayment searchForId(Long id) {
		
		return null;
	}

	@Override
	public MethodPayment add(MethodPayment methodPayment) {
		
		return null;
	}

	@Override
	public void remove(MethodPayment methodPayment) {
		
		
	}

}
