package com.restaurant.zomato.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
public class UserSelectedItem {
	private int itemId;
    private int quantity;
    
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
	
	public static void main(String[] args) {
		UserSelectedItem u=new UserSelectedItem();
		u.setItemId(23);
		u.setQuantity(3);
		System.out.print(u);
	}
	@Override
	public String toString() {
		return "UserSelectedItem [itemId=" + itemId + ", quantity=" + quantity + "]";
	}
    
}
