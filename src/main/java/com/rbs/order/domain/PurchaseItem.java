package com.rbs.order.domain;

public class PurchaseItem {
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	String item_id;
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public double getTotalSurcharge() {
		return totalSurcharge;
	}
	public void setTotalSurcharge(double totalSurcharge) {
		this.totalSurcharge = totalSurcharge;
	}
	String userType;
	int quantity;
	String item_name;
	double unitPrice;
	double totalPrice;
	double totalSurcharge ;

}
