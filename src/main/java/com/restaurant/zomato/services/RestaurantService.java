package com.restaurant.zomato.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.zomato.dao.RestaurantDao;
import com.restaurant.zomato.entities.Restaurant;

@Service
public class RestaurantService {
	@Autowired
	public RestaurantDao restaurantDao;

	public List<Restaurant> getAllRestaurant() {
		
		return restaurantDao.findAll();
	}

	public Restaurant getOneRestaurantById(int restaurantId) {
	
		return restaurantDao.getById(restaurantId);
	}
	
	public List<Restaurant> getAllRestaurantByAdd(String restaurantAdd) {
		
		return restaurantDao.findByAddress(restaurantAdd);
	}

	public Restaurant addRestaurant(Restaurant restaurant) {
		restaurantDao.save(restaurant);
		return restaurant;
	}

	public Restaurant updateRestaurant(Restaurant restaurant) {
		restaurantDao.save(restaurant);
		return restaurant;
		
	}

	public void deleteRestaurant(int restaurantId) {
		Restaurant entity=restaurantDao.getById(restaurantId);
		restaurantDao.delete(entity);
		
	}
	public Restaurant getAllRestaurantByAddress(String address,String name) {
		Restaurant temp = null;
		List<Restaurant> choiceRestaurant= restaurantDao.findByAddress(address);
		
		for(Restaurant x:choiceRestaurant) {
			if(x.getName().equals(name)) {
				temp= x;
			}
			
		}
		return temp;
	}


	public List<Restaurant> getRestaurantByAddress(String location) {
		return restaurantDao.findByAddress(location);
	}
}
