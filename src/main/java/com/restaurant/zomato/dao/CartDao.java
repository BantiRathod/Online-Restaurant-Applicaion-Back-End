package com.restaurant.zomato.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.zomato.entities.Cart;
import com.restaurant.zomato.entities.Items;

public interface CartDao extends JpaRepository<Cart, Integer> {
	
	 Cart findByphoneNumber(long phoneNumber);

}
