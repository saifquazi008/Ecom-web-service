package com.shopwaala.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.shopwaala.webservice.entity.WishList;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Long> {
	
	@Query("SELECT w FROM WishList w WHERE w.name =:name")
    public WishList getWishListByName(@Param("name") String name);

}
