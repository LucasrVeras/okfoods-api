package br.com.okfoodsapi.domain.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@JsonIgnore
	@Embedded
	private Address address;
	
	@JsonIgnore
	@CreationTimestamp
	@Column(name = "col_date_register", nullable = false)
	private LocalDateTime dateRegister;
	
	@JsonIgnore
	@UpdateTimestamp
	@Column(name = "col_date_Update", nullable = false)
	private LocalDateTime dateUpdate;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "tab_restaurant_methods_payment",
	    joinColumns = @JoinColumn(name = "col_restaurant_id"),
	    inverseJoinColumns = @JoinColumn(name = "col_method_payment_id"))
	private List<MethodPayment> methodsPayment = new ArrayList<>();
}
