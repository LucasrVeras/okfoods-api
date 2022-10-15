package br.com.okfoodsapi.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.okfoodsapi.domain.models.MethodPayment;
import br.com.okfoodsapi.domain.repositories.MethodPaymentRepository;

@RestController
@RequestMapping("/methodPayment")
public class MethodPaymentController {

	@Autowired
	private MethodPaymentRepository paymentRepository;
	
	@GetMapping
	public List<MethodPayment> list(){
		return paymentRepository.findAll();
	}
}
