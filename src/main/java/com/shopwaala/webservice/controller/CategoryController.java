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

import com.shopwaala.webservice.entity.Categories;
import com.shopwaala.webservice.entity.Order;
import com.shopwaala.webservice.entity.Product;
import com.shopwaala.webservice.exceptions.NotFoundException;
import com.shopwaala.webservice.repository.CategoriesRepository;

@RestController
public class CategoryController {

	@Autowired
	CategoriesRepository categoriesRepository;
	
	@GetMapping("/categories/{id}")
	public Optional<Categories> getCategoryById(@PathVariable("id") long id) {
		Optional<Categories> category=categoriesRepository.findById(id);
		 if(category !=null) {
			 return category;
		 }
		throw new NotFoundException("Category is not found with given id :"+ id);
	}
	
	
	@GetMapping("/category")
	public Optional<Categories> getCategoryByName(@RequestParam("name") String name) {
		return Optional.of(categoriesRepository.getCategoryByName(name));
	}
	
	@GetMapping("/categories")
	public List<Categories> getAllCategories() {
		List<Categories> list=categoriesRepository.findAll();
	    if(list.isEmpty()) {
	    	throw new NotFoundException("Categories Not Found, List is Empty !");
	    }
	    return list;
	}
	@PostMapping("/categories")
	public Categories addCategory( @RequestBody Categories categories) {
		return categoriesRepository.save(categories);
	}
	
	@PutMapping("/categories")
	public Categories updateCategories(@RequestBody Categories categories) {
		return categoriesRepository.save(categories);
	}
	
	@DeleteMapping("/category/{id}")
	public String deletecategoryById(@PathVariable("id") long id) {
		categoriesRepository.deleteById(id);
		return "category Deleted Successfully";
	}
	
	
}
