package com.restaurant.zomato.dto;

import java.util.List;

import com.restaurant.zomato.entities.Items;

public class CartResponseBody {

	private long userId;
	private int cartId;
	private List<Items> items;
	private long totalAmount;
	
	public CartResponseBody() {}
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public List<Items> getItems() {
		return items;
	}
	public void setItems(List<Items> items) {
		this.items = items;
	}

	public long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
	
}
