package com.restaurant.zomato.entities;


import lombok.Data;

import java.util.Date;

import javax.persistence.*;


@Data
@Entity
public class UserOrders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	@Column(nullable = false)
	private long userId;
	@Column(nullable = false)
	private int restaurantId;
	@Column(nullable = false)
	private int deliveryBoyId ;
	private String orderStatus;
	private long amount;
	private Date date;
	private int cartId;
	private int transactionId;
	public UserOrders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserOrders(int orderId, long userId, int restaurantId, int deliveryBoyId, String orderStatus, long amount,
			Date date, int cartId, int transactionId) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.deliveryBoyId = deliveryBoyId;
		this.orderStatus = orderStatus;
		this.amount = amount;
		this.date = date;
		this.cartId = cartId;
		this.transactionId = transactionId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public int getDeliveryBoyId() {
		return deliveryBoyId;
	}
	public void setDeliveryBoyId(int deliveryBoyId) {
		this.deliveryBoyId = deliveryBoyId;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	@Override
	public String toString() {
		return "UserOrders [orderId=" + orderId + ", userId=" + userId + ", restaurantId=" + restaurantId
				+ ", deliveryBoyId=" + deliveryBoyId + ", orderStatus=" + orderStatus + ", amount=" + amount + ", date="
				+ date + ", cartId=" + cartId + ", transactionId=" + transactionId + "]";
	}
	
	
	
	
}