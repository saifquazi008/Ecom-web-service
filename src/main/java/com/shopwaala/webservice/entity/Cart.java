package com.shopwaala.webservice.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "carts")
public class Cart {

	@Id
    @Column(name = "cart_id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "cart_generator")
	@SequenceGenerator(name = "cart_generator", initialValue = 1, allocationSize = 1, sequenceName = "cart_seq")
	private long id;
	
	@Column(name = "name")
	private String name;
		
	@Column(name = "total_price")
	private double totalPrice;
	
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private List<Product> products; 
}
