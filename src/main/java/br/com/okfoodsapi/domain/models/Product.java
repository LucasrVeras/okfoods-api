package br.com.okfoodsapi.domain.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
@Table(name = "tab_product")
public class Product {
    
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    
    @Column(name = "col_name")
    private String name;
    
    @Column(name = "col_description")
    private String description;
    
    @Column(name = "col_price")
    private BigDecimal price;
    
    @Column(name = "col_active")
    private Boolean active;
    
    @ManyToOne
    @JoinColumn(name = "col_restaurant_id")
    private Restaurant restaurant;
}
