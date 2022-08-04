package com.restaurant.zomato.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Getter
@Setter
public class DeliveryBoy {
	private String name;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deliveryBoyId;
	private String address;
	private int restaurantId;
	public DeliveryBoy() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String status;
	public DeliveryBoy(String name, int deliveryBoyId, String address, int restaurantId) {
		super();
		this.name = name;
		this.deliveryBoyId = deliveryBoyId;
		this.address = address;
		this.restaurantId = restaurantId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDeliveryBoyId() {
		return deliveryBoyId;
	}
	public void setDeliveryBoyId(int deliveryBoyId) {
		this.deliveryBoyId = deliveryBoyId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	@Override
	public String toString() {
		return "DeliveryBoy [name=" + name + ", deliveryBoyId=" + deliveryBoyId + ", address=" + address
				+ ", restaurantId=" + restaurantId  + "]";
	}

	
}
