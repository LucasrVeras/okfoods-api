package br.com.okfoodsapi.domain.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Table(name = "tb_order_item")
public class OrderItem {
	
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@Column(name = "col_quantitiy")
	private Integer quantity;
	
	@Column(name = "col_unit_Price")
	private BigDecimal UnitPrice;
	
	@Column(name = "col_total_price")
	private BigDecimal totalPrice;
	
	@Column(name = "col_notes")
	private String  notes;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	@Column(name = "col_order_id")
	private Order order;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	@Column(name = "col_product_id")
	private Product product;
}	
