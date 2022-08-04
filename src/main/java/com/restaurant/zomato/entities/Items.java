package com.restaurant.zomato.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@Data
public class Items {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemId;
	private int restaurantId;
	private String itemName;
	private int itemPrice;
	private int quantity;
	
	
	public Items(int itemId, int restaurantId, String itemName, int itemPrice, int quantity) {
		super();
		this.itemId = itemId;
		this.restaurantId = restaurantId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.quantity = quantity;
	}
	public Items() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "Items [itemId=" + itemId + ", restaurantId=" + restaurantId + ", itemName=" + itemName + ", itemPrice="
				+ itemPrice + ", quantity=" + quantity + "]";
	}
	
	
	

}
