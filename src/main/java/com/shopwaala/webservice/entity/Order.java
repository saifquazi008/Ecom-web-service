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
@Table(name = "orders")
public class Order {

	@Id
    @Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "order_generator")
	@SequenceGenerator(name = "order_generator", initialValue = 1, allocationSize = 1, sequenceName = "order_seq")
	private long id;

	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "price")
	private double price;

	@Column(name = "phone_no")
	private String phoneNo;

	@Column(name = "quantity")
	private long quantity;

	@Column(name = "address")
	private String address;

	@Column(name = "landmark")
	private String landmark;
	
	@Column(name = "pincode")
	private long pincode;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "country")
	private String country;

	@Column(name = "add_summary")
	private String addSummary;
	
	
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private List<Product> products;

}
