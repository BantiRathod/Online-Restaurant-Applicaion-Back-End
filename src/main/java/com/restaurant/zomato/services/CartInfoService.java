package com.restaurant.zomato.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.zomato.controllers.UserController;
import com.restaurant.zomato.dao.CartInfoDao;
import com.restaurant.zomato.entities.CartInfo;
import com.restaurant.zomato.entities.Items;

@Service
public class CartInfoService {

	Logger logger = LoggerFactory.getLogger(CartInfoService.class);
	
	@Autowired
	private CartInfoDao cartInfoDao;

	public void saveCartInfo(int id, List<Items> selectItem) {
		
		
		
		//FOR STORING INFO
		for (Items item : selectItem) {
			
			CartInfo temp = new CartInfo();
			if(item.getQuantity()==0)
				continue;
			
			

			temp.setCartId(id);
			logger.info("cartId :"+ id);
			
			
			
			temp.setTotalAmount(item.getItemPrice()*item.getQuantity());
			temp.setItemId(item.getItemId());
			temp.setItemPrice(item.getItemPrice());
			temp.setItemName(item.getItemName());
			temp.setQuantity(item.getQuantity());
			temp = cartInfoDao.save(temp);
			logger.info("saved object :" + temp);
			
		  }
		
		

	}
	
	public List<Items> getListOfItem(int cartId) {
		List<Items> item =cartInfoDao.findByCartId(cartId);
		return item;
	}
}
