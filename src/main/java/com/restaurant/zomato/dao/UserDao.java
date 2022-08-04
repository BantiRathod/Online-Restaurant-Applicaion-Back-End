package com.restaurant.zomato.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.zomato.entities.Users;



public interface UserDao extends JpaRepository<Users, Long> {

}
