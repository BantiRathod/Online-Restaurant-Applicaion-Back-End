package com.restaurant.zomato.dto;

import lombok.Data;

import java.util.List;
    
@Data
public class PreviewOrder {
	
    private int restaurantId;
    private long userId;
    List<UserSelectedItem> listOfItems;
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public List<UserSelectedItem> getListOfItems() {
		return listOfItems;
	}
	public void setListOfItems(List<UserSelectedItem> listOfItems) {
		this.listOfItems = listOfItems;
	}
    
    
}
