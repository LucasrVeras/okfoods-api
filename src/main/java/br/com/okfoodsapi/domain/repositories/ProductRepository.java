package br.com.okfoodsapi.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.okfoodsapi.domain.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
