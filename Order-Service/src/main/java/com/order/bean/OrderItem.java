package com.order.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_item_details")
public class OrderItem {
	
	@Id
	private Long id;
    private Long productId;
    private int quantity;
    private double productPrice;


}
