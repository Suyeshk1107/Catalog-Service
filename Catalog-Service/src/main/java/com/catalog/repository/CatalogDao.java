package com.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.catalog.bean.Product;

@Repository
public interface CatalogDao extends JpaRepository<Product, Long>{

	public Product findByCode(String productCode);
	
}
