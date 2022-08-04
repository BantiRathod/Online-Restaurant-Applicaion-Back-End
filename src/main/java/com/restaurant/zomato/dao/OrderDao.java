package com.restaurant.zomato.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.zomato.entities.UserOrders;


public interface OrderDao extends JpaRepository<UserOrders, Integer> {

}
