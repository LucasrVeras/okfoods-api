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
@Table(name = "tab_restaurant")
public class Restaurant {
	
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@Column(name = "col_name", nullable = false)
	private String name;
	
	@Column(name = "col_tax_shipping", nullable = false)
	private BigDecimal taxShipping;
	
	@ManyToOne
	@JoinColumn(name = "col_cuisine_id", nullable = false)
	private Cuisine cuisine;
	
//	@ManyToOne
//	@JoinColumn(name = "col_methodPayment_id")
//	private MethodPayment methodPayment;
}
