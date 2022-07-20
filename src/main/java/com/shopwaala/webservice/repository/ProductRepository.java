package com.shopwaala.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.shopwaala.webservice.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	  @Query("SELECT p FROM Product p WHERE p.name =:name")
	    public Product getProductByName(@Param("name") String name);

}
