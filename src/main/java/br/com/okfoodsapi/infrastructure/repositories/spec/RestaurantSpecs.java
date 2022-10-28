package br.com.okfoodsapi.infrastructure.repositories.spec;

import br.com.okfoodsapi.domain.models.Restaurant;

import java.math.BigDecimal;

import org.springframework.data.jpa.domain.Specification;

public class RestaurantSpecs {

    public static Specification<Restaurant> WithFreeShipping(){
        return (root, query, builder) ->
        	builder.equal(root.get("taxShipping"), BigDecimal.ZERO);
    }

    public static Specification<Restaurant> NameSimilarSpec(String name){
        return (root, query, builder) ->
        	builder.like(root.get("name"), "%" + name + "%");
    }
}
	