package com.catalog.resources;

import org.springframework.http.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.catalog.bean.Product;
import com.catalog.bean.ProductList;
import com.catalog.service.CatalogService;

@RestController
public class CatalogResource {
	
	@Autowired
	private CatalogService catalogService;
	
	
	@GetMapping(path = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductList listAllProducts() {
		return catalogService.listAllProducts();
	}
	@GetMapping(path = "/products/code/{productCode}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Product getProductByCode(@PathVariable("productCode") String productCode) {
		return catalogService.getProductByCode(productCode);
	}

}
