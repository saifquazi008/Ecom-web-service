package com.shopwaala.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shopwaala.webservice.entity.Categories;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long>{
	
	@Query("SELECT c FROM Categories c WHERE c.name =:name")
    public Categories getCategoryByName(@Param("name") String name);


}
