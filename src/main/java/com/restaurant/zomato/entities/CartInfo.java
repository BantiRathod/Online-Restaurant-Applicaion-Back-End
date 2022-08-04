package com.restaurant.zomato.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class CartInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CartInfo;
	
	private int cartId;
    private int itemId;
    private int quantity;
    private String itemName;
    private int itemPrice;
    private long totalAmount;
    
	public CartInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartInfo(int cartInfo, int cartId, int itemId, int quantity, String itemName, int itemPrice,
			long totalAmount) {
		super();
		CartInfo = cartInfo;
		this.cartId = cartId;
		this.itemId = itemId;
		this.quantity = quantity;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.totalAmount = totalAmount;
	}
	public int getCartInfo() {
		return CartInfo;
	}
	public void setCartInfo(int cartInfo) {
		CartInfo = cartInfo;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
	public long getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
	}
	@Override
	public String toString() {
		return "CartInfo [CartInfo=" + CartInfo + ", cartId=" + cartId + ", itemId=" + itemId + ", quantity=" + quantity
				+ ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", totalAmount=" + totalAmount + "]";
	}
    
    
    
    
}