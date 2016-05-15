package com.rbs.order.domain;

import java.util.List;

public class Receipt {
	
	String order_reference;
	List<PurchaseItem> items;
	double totalPurchaseAmount;
	public double getTotalPurchaseAmount() {
		return totalPurchaseAmount;
	}
	public void setTotalPurchaseAmount(double totalPurchaseAmount) {
		this.totalPurchaseAmount = totalPurchaseAmount;
	}
	public Receipt(String order_reference, List<PurchaseItem> items, double totalPurchaseAmount,
			double totalSurcharge) {
		super();
		this.order_reference = order_reference;
		this.items = items;
		this.totalPurchaseAmount = totalPurchaseAmount;
		this.totalSurcharge = totalSurcharge;
	}
	public double getTotalSurcharge() {
		return totalSurcharge;
	}
	public void setTotalSurcharge(double totalSurcharge) {
		this.totalSurcharge = totalSurcharge;
	}
	double totalSurcharge;
	
	public String getOrder_reference() {
		return order_reference;
	}
	public void setOrder_reference(String order_reference) {
		this.order_reference = order_reference;
	}
	public List<PurchaseItem> getItems() {
		return items;
	}
	public void setItems(List<PurchaseItem> items) {
		this.items = items;
	}
	public Receipt(String order_reference, List<PurchaseItem> items) {
		super();
		this.order_reference = order_reference;
		this.items = items;
	}

}
