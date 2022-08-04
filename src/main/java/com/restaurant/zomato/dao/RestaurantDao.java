package com.restaurant.zomato.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.zomato.entities.Restaurant;


public interface RestaurantDao extends JpaRepository<Restaurant, Integer> {

	List<Restaurant> findByAddress(String address);
	

}
