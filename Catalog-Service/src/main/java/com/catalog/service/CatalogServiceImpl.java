package com.catalog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalog.bean.Product;
import com.catalog.bean.ProductList;
import com.catalog.repository.CatalogDao;

@Service
public class CatalogServiceImpl implements CatalogService{

	@Autowired
	private CatalogDao catalogDao;
	
	@Override
	public ProductList listAllProducts() {

		ProductList products = new ProductList(catalogDao.findAll());
		return products;
	}

	@Override
	public Product getProductByCode(String productCode) {
		// TODO Auto-generated method stub
		return catalogDao.findByCode(productCode);
	}

}
