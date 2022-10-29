package br.com.okfoodsapi.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.okfoodsapi.domain.models.Product;
import br.com.okfoodsapi.domain.repositories.ProductRepository;
import br.com.okfoodsapi.domain.services.ProductRegistrationService;

@RestController
@RequestMapping("/product")
public class ProductController {
   
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private ProductRegistrationService productService;
    
    @GetMapping
    public List<Product> list(){
        return productRepository.findAll();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product add(@RequestBody Product product) {
        return productService.add(product);
    }

}
