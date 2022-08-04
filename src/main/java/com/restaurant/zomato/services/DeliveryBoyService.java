package com.restaurant.zomato.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.zomato.dao.DeliveryBoyDao;
import com.restaurant.zomato.entities.DeliveryBoy;

@Service
public class DeliveryBoyService {
	@Autowired
	public DeliveryBoyDao deliveryBoyDao;

	public List<DeliveryBoy> getAllDeliveryBoy() {
		
		return deliveryBoyDao.findAll();
	}

	public DeliveryBoy getOneDeliveryBoy(int deliveryBoyId) {
	
		return deliveryBoyDao.getById(deliveryBoyId);
	}

	public DeliveryBoy addDeliveryBoy(DeliveryBoy deliveryBoy) {
		deliveryBoyDao.save(deliveryBoy);
		return deliveryBoy;
	}

	public DeliveryBoy updateDeliveryBoy(DeliveryBoy deliveryBoy) {
		deliveryBoyDao.save(deliveryBoy);
		return deliveryBoy;
		
	}

	public void deleteDeliveryBoy(int deliveryBoyId) {
		DeliveryBoy entity=deliveryBoyDao.getById(deliveryBoyId);
		deliveryBoyDao.delete(entity);
		
	}
	
	public DeliveryBoy getDeliveryBoyByRestaurantId(int restaurantId) {
		DeliveryBoy boy;
		boy = deliveryBoyDao.findByRestaurantId(restaurantId);
				return boy;
	}


}
