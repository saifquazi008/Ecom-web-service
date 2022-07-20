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
@Table(name = "wishlist")
public class WishList {
	
	@Id
    @Column(name = "wishlist_id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "wishlist_generator")
	@SequenceGenerator(name = "wishlist_generator", initialValue = 1, allocationSize = 1, sequenceName = "wishlist_seq")
	private long id;
	
	@Column(name = "name")
	private String  name;
	
	@Column(name = "available")
	private boolean available;
	
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private List<Product> products; 

}
