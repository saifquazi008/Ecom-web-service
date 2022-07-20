package com.shopwaala.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shopwaala.webservice.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>  {

	@Query("SELECT c FROM Cart c WHERE c.name =:name")
    public Cart getCartByName(@Param("name") String name);
}
