package com.rbs.order.domain;

public class PurchaseItem {
	
	public String getItem_code() {
		return item_code;
	}
	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}
	public String getItem_type() {
		return item_type;
	}
	public void setItem_type(String item_type) {
		this.item_type = item_type;
	}
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
	public double getTotalItemPrice() {
		return totalItemPrice;
	}
	public void setTotalItemPrice(double totalItemPrice) {
		this.totalItemPrice = totalItemPrice;
	}
	public double getItemSurchargeAmount() {
		return itemSurchargeAmount;
	}
	public void setItemSurchargeAmount(double itemSurchargeAmount) {
		this.itemSurchargeAmount = itemSurchargeAmount;
	}
	String item_code;
	String item_type;
	int quantity;
	String item_name;
	double unitPrice;
	double totalItemPrice;
	double itemSurchargeAmount;

}
