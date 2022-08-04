package com.restaurant.zomato.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.zomato.controllers.UserController;
import com.restaurant.zomato.dao.CartDao;
import com.restaurant.zomato.dao.CartInfoDao;
import com.restaurant.zomato.dto.CartResponseBody;
import com.restaurant.zomato.entities.Cart;
import com.restaurant.zomato.entities.CartInfo;
import com.restaurant.zomato.entities.Items;

@Service
public class CartService {

	Logger logger = LoggerFactory.getLogger(CartService.class);

	@Autowired
	public CartDao cartDao;

	@Autowired
	public CartInfoDao cartInfoDao;

	@Autowired
	public CartInfoService cartInfoService;

	public CartResponseBody saveCart(long phoneNumber, List<Items> selectedItem) {

		Cart temp = new Cart();
		temp.setPhoneNumber(phoneNumber);
		temp.setRestaurentId(selectedItem.get(0).getRestaurantId());
		temp.setDate(new Date());
		temp = cartDao.save(temp);
		logger.info("cart details has been stored successfully");

		cartInfoService.saveCartInfo(temp.getCartId(), selectedItem);
		logger.info("items details  has been stored in cartInfo table successfully");

		return createCartResponseBody(temp.getCartId(), phoneNumber, selectedItem);
	}

	public CartResponseBody createCartResponseBody(int cartId, long phoneNumber, List<Items> selectedItem) {
		CartResponseBody res = new CartResponseBody();
		ArrayList<Items> newlist = new ArrayList<Items>();

		long totalAmount = 0;

		for (Items item : selectedItem) {
			if (item.getQuantity() == 0)
				continue;

			newlist.add(item);
			totalAmount += (item.getItemPrice() * item.getQuantity());
		}

		res.setUserId(phoneNumber);
		res.setCartId(cartId);
		res.setItems(newlist);
		res.setTotalAmount(totalAmount);

		return res;

	}

	public List<Items> getAllItemByPhoneNumber(long phoneNumber) {
		Cart temp = null;
		temp = cartDao.findByphoneNumber(phoneNumber);

		return cartInfoDao.findByCartId(temp.getCartId());
	}

	public CartInfo updateCart(CartInfo cartInfo) {
		// TODO Auto-generated method stub
		cartInfoDao.save(cartInfo);
		return cartInfo;
	}
}