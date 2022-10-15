package br.com.okfoodsapi.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.okfoodsapi.domain.models.MethodPayment;

@Repository
public interface MethodPaymentRepository extends JpaRepository<MethodPayment, Long> {
}
