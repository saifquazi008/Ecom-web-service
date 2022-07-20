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

import com.shopwaala.webservice.entity.Product;
import com.shopwaala.webservice.exceptions.NotFoundException;
import com.shopwaala.webservice.repository.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	ProductRepository productRepo;

	@GetMapping("/products/{id}")
	public Optional<Product> getProductById(@PathVariable("id") long id) {
		Optional<Product> product = productRepo.findById(id);
		if (product != null) {
			return product;
		}
		throw new NotFoundException("Product is not found with id : " + id);
	}

	@GetMapping("/product")
	public Optional<Product> getProductByName(@RequestParam("name") String name) {
		return Optional.of(productRepo.getProductByName(name));
	}

	@GetMapping("/products")
	public List<Product> getAllProducts() {
		List<Product> list = productRepo.findAll();
		if (list.isEmpty()) {
			throw new NotFoundException("Product Not Found, List is Empty !");
		}
		return list;
	}

	@PostMapping("/products")
	public Product addProduct(@RequestBody Product product) {
		return productRepo.save(product);
	}

	@PutMapping("/products")
	public Product updateProduct(@RequestBody Product product) {
		return productRepo.save(product);
	}

	@DeleteMapping("/product/{id}")
	public String deleteProductById(@PathVariable("id") long id) {
		productRepo.deleteById(id);
		return "Product Deleted Successfully";
	}

}
