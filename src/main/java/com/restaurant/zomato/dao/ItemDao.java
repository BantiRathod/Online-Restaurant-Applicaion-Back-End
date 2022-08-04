package com.restaurant.zomato.dao;

import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.zomato.entities.Items;

public interface ItemDao extends JpaRepository<Items, Integer> {

	List<Items> findByRestaurantId(int restaurantId);

	 

}
