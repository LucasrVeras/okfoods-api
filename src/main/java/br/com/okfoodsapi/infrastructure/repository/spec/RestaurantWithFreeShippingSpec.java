package br.com.okfoodsapi.infrastructure.repository.spec;

import java.math.BigDecimal;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.okfoodsapi.domain.models.Restaurant;

public class RestaurantWithFreeShippingSpec implements Specification<Restaurant> {

    private static final long serialVersionUID = 1L;

	@Override
    public Predicate toPredicate(Root<Restaurant> root, CriteriaQuery<?> query,
                                 CriteriaBuilder builder) {
        return builder.equal(root.get("taxShipping"), BigDecimal.ZERO);
    }
}
