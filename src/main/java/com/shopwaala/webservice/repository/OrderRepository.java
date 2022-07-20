package com.shopwaala.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shopwaala.webservice.entity.Order;
import com.shopwaala.webservice.entity.Product;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	
	 @Query("SELECT o FROM Order o WHERE o.name =:name")
	    public Order getOrderByName(@Param("name") String name);

}
