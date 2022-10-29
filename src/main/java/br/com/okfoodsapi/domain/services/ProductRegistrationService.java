package br.com.okfoodsapi.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.okfoodsapi.domain.models.Product;
import br.com.okfoodsapi.domain.repositories.ProductRepository;

@Service
public class ProductRegistrationService {
    
    @Autowired
    private ProductRepository productRepository;
    
    public Product add(Product product) {
        return productRepository.save(product);
    }
}
