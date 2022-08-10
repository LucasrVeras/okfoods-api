package br.com.okfoodsapi.domain.repositories;

import java.util.List;

import br.com.okfoodsapi.domain.models.MethodPayment;

public interface MethodPaymentRepository {
	
	List<MethodPayment> all();
	MethodPayment searchForId(Long id);
	MethodPayment add(MethodPayment methodPayment);
	void remove(MethodPayment methodPayment);
}
