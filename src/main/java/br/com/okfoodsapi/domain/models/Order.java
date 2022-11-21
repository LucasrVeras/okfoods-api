package br.com.okfoodsapi.domain.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Table(name = "tb_order")
public class Order {
	
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@ManyToOne
	@Column(name = "col_client_id", nullable = false)
	private User client;
	
	@Column(name = "col_sub_total")
	private BigDecimal subTotal;
	
	@Column(name = "col_tax_shipping")
	private BigDecimal taxShipping;
	
	@Column(name = "col_amount")
	private BigDecimal amount;
	
	@OneToMany(mappedBy = "order")
	private List<OrderItem> itens = new ArrayList<>();
	
	@Column(name = "col_restaurant_id")
	@ManyToOne
	@JoinColumn(nullable = false)
	private Restaurant restaurant;
	
	
	@Column(name = "col_method_payment_id")
	@ManyToOne
	@JoinColumn(nullable = false)
	private MethodPayment methodPayment;
	
	@Embedded
	@JsonIgnore
	private Address address;
	
	@CreationTimestamp
	@Column(name = "col_creation_date")
	private LocalDateTime creationDate;
	
	@CreationTimestamp
	@Column(name = "col_confirmation_date")
	private LocalDateTime confirmationDate;
	
	@CreationTimestamp
	@Column(name = "col_cancellation_date")
	private LocalDateTime cancellationDate;
	
	@CreationTimestamp
	@Column(name = "col_delivery_date")
	private LocalDateTime deliveryDate;
	
	@Column(name = "col_order_status")
	private OrderStatus orderStatus;
}
