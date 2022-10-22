package br.com.okfoodsapi.infrastructure.repository.spec;

import br.com.okfoodsapi.domain.models.Restaurant;
import lombok.AllArgsConstructor;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@AllArgsConstructor
public class RestaurantNameSimilarSpec implements Specification<Restaurant> {

    private static final long serialVersionUID = 1l;
    
    private String name;

    @Override
    public Predicate toPredicate(Root<Restaurant> root, CriteriaQuery<?> query,
                                 CriteriaBuilder builder) {

        return builder.like(root.get("name"), "%" + name + "%");
    }
}
