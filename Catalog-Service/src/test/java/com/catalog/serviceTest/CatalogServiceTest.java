package com.catalog.serviceTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.catalog.bean.Product;
import com.catalog.repository.CatalogDao;
import com.catalog.service.CatalogServiceImpl;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CatalogServiceTest {
	
	@InjectMocks
	@Autowired
	private CatalogServiceImpl catalogService;
	
	@Mock
	private CatalogDao catalogDao;

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void all_Product_T001() {
		List<Product> products = new ArrayList<>();
		products.add(new Product(1001L, "P001", "Chocos", "Milk Cereal", 100.0));
		products.add(new Product(1002L, "P002", "Perk", "Choclate", 50.0));
		products.add(new Product(1003L, "P003", "Crax Curls", "Corn Snack", 10.0));
		Mockito.when(catalogDao.findAll()).thenReturn(products);
		assertEquals(products,catalogService.listAllProducts().getProducts());
	}

	@Test
	void product_By_Code_T001() {
		Product product = new Product(1002L, "P002", "Perk", "Choclate", 50.0);
		Mockito.when(catalogDao.findByCode("P002")).thenReturn(product);	
		assertEquals(product, catalogService.getProductByCode("P002"));
	}
	
	@Test
	void product_By_Code_T002() {
		Product product = new Product(1001L, "P001", "Chocos", "Milk Cereal", 100.0);
		Mockito.when(catalogDao.findByCode("P001")).thenReturn(product);	
		assertEquals(product, catalogService.getProductByCode("P001"));
	}
	
	@Test
	void product_By_Code_T003() {
		Mockito.when(catalogDao.findByCode("P111")).thenReturn(null);		
		assertEquals(null, catalogService.getProductByCode("P111"));
	}
	
	@Test
	void product_By_Code_T004() {
		Mockito.when(catalogDao.findByCode("P112")).thenReturn(null);		
		assertEquals(null, catalogService.getProductByCode("P112"));
	}

}
