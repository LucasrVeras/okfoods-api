package br.com.okfoodsapi.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.okfoodsapi.domain.models.MethodPayment;
import br.com.okfoodsapi.domain.repositories.MethodPaymentRepository;

@Service
public class MethodPaymentRegistrationService {
	
	@Autowired
	private MethodPaymentRepository paymentRepository;
	
	public MethodPayment add(MethodPayment methodPayment) {
		return paymentRepository.save(methodPayment);
	}
}
