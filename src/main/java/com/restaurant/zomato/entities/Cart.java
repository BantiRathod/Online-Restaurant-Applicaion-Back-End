package com.restaurant.zomato.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CartId;
	private long phoneNumber;
	private int restaurentId;
	private Date date;
	
	
	public Cart() {}
	
	public Cart(int cartId, long phoneNumber, int restaurentId, Date date) {
		super();
		CartId = cartId;
		this.phoneNumber = phoneNumber;
		this.restaurentId = restaurentId;
		this.date = date;
	
	}
	public int getCartId() {
		return CartId;
	}
	public void setCartId(int cartId) {
		CartId = cartId;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getRestaurentId() {
		return restaurentId;
	}
	public void setRestaurentId(int restaurentId) {
		this.restaurentId = restaurentId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
