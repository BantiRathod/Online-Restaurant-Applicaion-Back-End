package com.restaurant.zomato.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurant.zomato.entities.CartInfo;
import com.restaurant.zomato.entities.Items;

public interface CartInfoDao extends JpaRepository <CartInfo,Integer>  {

	List<Items> findByCartId(int cartId);

}
