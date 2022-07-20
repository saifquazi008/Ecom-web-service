package com.shopwaala.webservice.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
	
	@Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private double price;

	@Column(name = "description")
	private String description;

	@Column(name = "available")
	private boolean available;

	@Column(name = "expiry_date")
	private String expiryDate;

	@Column(name = "stock")
	private long stock;

	@Column(name = "product_type")
	private String productType;

	@Column(name = "manufacturer")
	private String manufacturer;
	
	@Column(name = "mfg_date")
	private String mfgDate;

	@Column(name = "seller")
	private String seller;
	
	@Column(name = "quantity")
	private long quantity;
	
	@Lob
	@Column(name = "image")
	private byte[] image;
	
	@Column(name = "batch_no")
	private String batchNo;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	Order order;
}
