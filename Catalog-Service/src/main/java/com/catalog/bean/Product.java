package com.catalog.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="products_details")
public class Product {
	
	@Id
    private Long id;
    private String code;
    private String name;
    private String description;
    private double price;


}
