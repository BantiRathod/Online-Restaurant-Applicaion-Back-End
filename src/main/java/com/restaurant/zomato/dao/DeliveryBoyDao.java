package com.restaurant.zomato.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.zomato.entities.DeliveryBoy;


public interface DeliveryBoyDao extends JpaRepository<DeliveryBoy, Integer> {

	DeliveryBoy findByRestaurantId(int restaurantId);

}
