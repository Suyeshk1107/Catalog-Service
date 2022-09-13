package com.catalog.main;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.catalog.bean.Product;
import com.catalog.repository.CatalogDao;

@SpringBootTest
class CatalogServiceApplicationTests {

	@Autowired
	private CatalogDao catalogDao;
	
	@Test
	void contextLoads() {
	}

	@Test
	public void all_Product_T001() {
		List<Product> products = new ArrayList<>();
		products.add(new Product(1001L, "P001", "Chocos", "Milk Cereal", 100.0));
		products.add(new Product(1002L, "P002", "Perk", "Choclate", 50.0));
		products.add(new Product(1003L, "P003", "Crax Curls", "Corn Snack", 10.0));
		assertEquals(products,catalogDao.findAll());
	}
	@Test
	public void product_By_Code_T001() {
		Product product = new Product(1001L, "P001", "Chocos", "Milk Cereal", 100.0);
		assertEquals(product,catalogDao.findByCode("P001"));
	}
	@Test
	public void product_By_Code_T002() {
		Product product = new Product(1002L, "P002", "Perk", "Choclate", 50.0);
		assertEquals(product,catalogDao.findByCode("P002"));
	}
	@Test
	public void product_By_Code_T003() {
		Product product = new Product(1003L, "P003", "Crax Curls", "Corn Snack", 10.0);
		assertEquals(product,catalogDao.findByCode("P003"));
	}
	@Test
	public void product_By_Code_T004() {
		assertEquals(null,catalogDao.findByCode("P111"));
	}
	@Test
	public void product_By_Code_T005() {
		assertEquals(null,catalogDao.findByCode("P112"));
	}
}
