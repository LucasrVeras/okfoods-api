package br.com.okfoodsapi.jpa.methodPayment;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import br.com.okfoodsapi.OkfoodsApiApplication;
import br.com.okfoodsapi.domain.models.MethodPayment;
import br.com.okfoodsapi.domain.repositories.MethodPaymentRepository;

public class MethodPaymentMain{ 
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = 
				new SpringApplicationBuilder(OkfoodsApiApplication.class)
					.web(WebApplicationType.NONE)
					.run(args);
		
		MethodPaymentRepository methodPaymentRepository = applicationContext
				.getBean(MethodPaymentRepository.class);
	
		List<MethodPayment> allCity = methodPaymentRepository.all();
		
		for (MethodPayment methodPayment : allCity) {
			System.out.printf("%s \n", methodPayment.getDescription());
		}
	}
}
