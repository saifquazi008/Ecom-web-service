package com.shopwaala.webservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopwaala.webservice.entity.Cart;
import com.shopwaala.webservice.exceptions.NotFoundException;
import com.shopwaala.webservice.repository.CartRepository;

@RestController
public class CartController {
	
	
	@Autowired
	CartRepository cartRepository;
	
	@GetMapping("/carts")
	public List<Cart> getAllCart(){
		List<Cart> list=cartRepository.findAll();
	    if(list.isEmpty()) {
	    	throw new NotFoundException("Cart Not Found, List is Empty !");
	    }
	    return list;
	}
	
	@GetMapping("/carts/{id}")
	public Optional<Cart> getCartById(@PathVariable("id") long id) {
		Optional<Cart> cart=cartRepository.findById(id);
		if(cart !=null) {
			return cart;
		}
		throw new NotFoundException("Cart is not found with id : "+id);
	}
	
	@PostMapping("/carts")
	public Cart addCart(@RequestBody Cart cart) {
		return cartRepository.save(cart);
	}
	@PutMapping("/carts/{id}")
	public Cart updateCart(@RequestBody Cart cart,@PathVariable("id")long id){
		return cartRepository.save(cart);
	}
	@DeleteMapping("/cart/{id}")
	public String deleteCart(@PathVariable("id") long id) {
		cartRepository.deleteById(id);
		return "Cart is deleted successfully !";
		
	}
}
