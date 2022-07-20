package com.shopwaala.webservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopwaala.webservice.entity.Product;
import com.shopwaala.webservice.entity.WishList;
import com.shopwaala.webservice.exceptions.NotFoundException;
import com.shopwaala.webservice.repository.WishListRepository;

@RestController
public class WishListController {

	@Autowired
	WishListRepository listRepository;

	@GetMapping("/wishlists/{id}")
	public Optional<WishList> getWishListById(@PathVariable("id") long id) {
		Optional<WishList> wishList=listRepository.findById(id);
		if(wishList !=null) {
			return wishList;
		}
		throw new NotFoundException("Wishlist is not found with id : "+id);
	}
	@GetMapping("/wishlist")
	public Optional<WishList> getWishListByName(@RequestParam("name") String name) {
		return Optional.of(listRepository.getWishListByName(name));
	}

	@GetMapping("/wishlists")
	public List<WishList> getAllList() {
		List<WishList> list=listRepository.findAll();
	    if(list.isEmpty()) {
	    	throw new NotFoundException("WishList Not Found, List is Empty !");
	    }
	    return list;
	}

	@PostMapping("/wishlists")
	public WishList addToWishList(@RequestBody WishList wishList) {
		return listRepository.save(wishList);
	}

	@DeleteMapping("/wishlist/{id}")
	public String deleteWishlistyId(@PathVariable("id") long id) {
		listRepository.deleteById(id);
		return "Wishlist Deleted Successfully";
	}
}
