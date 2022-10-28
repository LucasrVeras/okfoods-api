package br.com.okfoodsapi.domain.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Address {
   
    @Column(name = "col_address_cep")
    private String cep;
    
    @Column(name = "col_address_logradouro")
    private String logradouro;
    
    @Column(name = "col_address_number")
    private String number;
    
    @Column(name = "col_address_complement")
    private String complement;
    
    @Column(name = "col_address_district")
    private String district; // Bairro?
    
    @ManyToOne
    @JoinColumn(name = "col_address_city_id")
    private City city;
    
}
