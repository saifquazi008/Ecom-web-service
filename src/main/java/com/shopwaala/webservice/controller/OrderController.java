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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopwaala.webservice.entity.Order;
import com.shopwaala.webservice.exceptions.NotFoundException;
import com.shopwaala.webservice.repository.OrderRepository;

@RestController
public class OrderController {
	
	@Autowired
	OrderRepository orderRepository;
	
	@GetMapping("/orders/{id}")
	public Optional<Order> getOrderById(@PathVariable("id") long id) {
		Optional<Order> order=orderRepository.findById(id);
		 if(order !=null) {
			 return order;
		 }
		throw new NotFoundException("Order is not found with given id :"+ id);
	}
	
	@GetMapping("/order")
	public Optional<Order> getOrderByName(@RequestParam("name") String name) {
		return Optional.of(orderRepository.getOrderByName(name));
	}
	
	@GetMapping("/orders")
	public List<Order> getAllOrder() {
		List<Order> list=orderRepository.findAll();
			if(list.isEmpty()) {
				throw new NotFoundException("Order Not Found, List is Empty !");
			}
		return list;
	}
	
	@PostMapping("/orders")
	public Order addOrder( @RequestBody Order order) {
		return orderRepository.save(order);
	}
	
	@PutMapping("/orders")
	public Order updateOrder(@RequestBody Order order) {
		return orderRepository.save(order);
	}
	
	@DeleteMapping("/order/{id}")
	public String deleteOrderById(@PathVariable("id") long id) {
		orderRepository.deleteById(id);
		return "Order Deleted Successfully";
	}

}
