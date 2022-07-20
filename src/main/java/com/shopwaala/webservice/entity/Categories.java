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
@Table(name = "categories")
public class Categories {
	
	@Id
    @Column(name = "category_id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "category_generator")
	@SequenceGenerator(name = "category_generator", initialValue = 1, allocationSize = 1, sequenceName = "category_seq")
	private long id;

	@Column(name = "category_name")
	private String name;
	
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private List<Product> products;

}
