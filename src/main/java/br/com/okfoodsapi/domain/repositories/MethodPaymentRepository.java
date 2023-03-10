package br.com.okfoodsapi.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.okfoodsapi.domain.models.MethodPayment;

public interface MethodPaymentRepository extends JpaRepository<MethodPayment, Long> {
    boolean existsByName(String name);
}
