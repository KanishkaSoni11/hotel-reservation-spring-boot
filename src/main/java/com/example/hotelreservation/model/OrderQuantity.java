package com.example.hotelreservation.model;

public class OrderQuantity {

	public OrderQuantity() {
	}

	// TODO: Maybe also include an additional column for quantity?
	private int orderId;
	private int itemId;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
}
