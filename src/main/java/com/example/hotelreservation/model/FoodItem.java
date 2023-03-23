package com.example.hotelreservation.model;

public class FoodItem {

	public FoodItem() {

	}

	private int itemId;
	private String itemName;
	private String itemDescription;
	private int itemAvailable;
	private int cost;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public int getItemAvailable() {
		return itemAvailable;
	}

	public void setItemAvailable(int itemAvailable) {
		this.itemAvailable = itemAvailable;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
}
