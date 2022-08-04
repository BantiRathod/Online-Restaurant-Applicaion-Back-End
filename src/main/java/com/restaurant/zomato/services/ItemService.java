package com.restaurant.zomato.services;

import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.zomato.dao.ItemDao;
import com.restaurant.zomato.entities.Items;


@Service
public class ItemService {
	@Autowired
	public ItemDao itemDao;

	public List<Items> getAllItem() {
		
		return itemDao.findAll();
	}

	public Items getOneItem(Integer itemId) {
	
		return itemDao.getById(itemId);
	}

	public Items addItem(Items item) {
		itemDao.save(item);
		return item;
	}

	public Items updateItem(Items item) {
	
		itemDao.save(item);
		return item;
		
	}

	public void deleteItem(int itemId) {
		Items entity=itemDao.getById(itemId);
		itemDao.delete(entity);
		
	}
	public List<Items> getAllRestaurantItems(int restaurantId){
		
		List<Items> item = itemDao.findByRestaurantId(restaurantId);
		return item;
	}

	public List<Items> getAllItemByRestaurantId(int restaurantId) {
		 List<Items> item =itemDao.findByRestaurantId(restaurantId);
		return item;
	}

	public void save(Items item) {
		itemDao.save(item);
		
	}

}
