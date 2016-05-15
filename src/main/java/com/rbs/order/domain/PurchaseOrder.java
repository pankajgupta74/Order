package com.rbs.order.domain;

import java.util.List;

import org.springframework.data.annotation.Id;

public class PurchaseOrder {
	
	@Id
	String order_reference;
	
	public PurchaseOrder(String order_reference, List<PurchaseItem> orderItems) {
		super();
		this.order_reference = order_reference;
		this.orderItems = orderItems;
	}

	public String getOrder_reference() {
		return order_reference;
	}

	public void setOrder_reference(String order_reference) {
		this.order_reference = order_reference;
	}

	public List<PurchaseItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<PurchaseItem> orderItems) {
		this.orderItems = orderItems;
	}

	List<PurchaseItem> orderItems;
	

}
