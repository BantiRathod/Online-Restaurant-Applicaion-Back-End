package com.restaurant.zomato.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.zomato.entities.Items;
import com.restaurant.zomato.services.ItemService;
import com.restaurant.zomato.validation.UsersRequestBodyValidation;

@RestController
@CrossOrigin(origins = { "http://localhost:3000" })
public class ItemController {

	Logger logger = LoggerFactory.getLogger(ItemController.class);
	@Autowired
	public ItemService itemService;

	@GetMapping("/items")

	/*
	 * This API is responsible for fetching all Items Records from Database
	 * 
	 * @RequestBody :- NA
	 * 
	 * @Response Body :- Return List Of Items, who have registered in application
	 * successfully.
	 * 
	 * 
	 */
	public ResponseEntity<?> getAllItem() {
		List<Items> temp = null;
		try {
			temp = this.itemService.getAllItem();
			if (temp.size() == 0)
				throw new Exception("not found any Item");
			else
				logger.info("item founded successfully");
			return new ResponseEntity<>(temp, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
		}

	}

	/*
	 * This API is responsible for fetching menu of restaurant Records from Database
	 * 
	 * @RequestBody :- restaurantId
	 * 
	 * @Response Body :- Return ListOfItems , who have registered in application
	 * successfully.
	 * 
	 * 
	 */
	@GetMapping("/menu/{restaurantId}")
	public ResponseEntity<?> getAllItemByRestaurantId(@PathVariable int restaurantId) {
		List<Items> temp = null;
		try {

			logger.info("Received restaurantId {}", restaurantId);
			UsersRequestBodyValidation.validateRestaurantId(restaurantId);
			temp = this.itemService.getAllItemByRestaurantId(restaurantId);
			logger.info("Saved RestaurantId {}", restaurantId);
			return new ResponseEntity<>(temp, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);

		}

	}

	/*
	 * This API is responsible for fetching oneItem of restaurant Records from
	 * Database
	 * 
	 * @RequestBody :- itemId
	 * 
	 * @Response Body :- Return Items which contains -
	 * itemId,RestaurantId,itemName<ItemPrice,quantity who have registered in
	 * application successfully.
	 * 
	 * 
	 */

	@GetMapping("/items/{itemId}")
	public ResponseEntity<?> getOneItem(@PathVariable int itemId) {
		Items item = null;
		try {
			UsersRequestBodyValidation.validateItemName(itemId);
			item = this.itemService.getOneItem(itemId);
			logger.info("item found Successfully");
			return new ResponseEntity<>(item, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);

		}

	}

	/*
	 * This API is responsible for Add Item of Restaurant in application
	 * 
	 * @RequestBody :- Items which contains -
	 * itemId,RestaurantId,itemName<ItemPrice,quantity.
	 * 
	 * @Response Body :- Return Items which contains -
	 * itemId,RestaurantId,itemName<ItemPrice,quantity.
	 * 
	 * 
	 */

	@PostMapping("/items")
	public ResponseEntity<?> addItem(@RequestBody Items item) {
		Items temp = null;
		try {
			UsersRequestBodyValidation.validateItemField(item.getRestaurantId(), item.getItemName(),
					item.getItemPrice());
			temp = this.itemService.addItem(item);
			logger.info("item addes Successfully");
			return new ResponseEntity<>(temp, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
		}

	}

	/*
	 * This API is responsible for update Item of Restaurant in application
	 * 
	 * @RequestBody :- Items which contains -
	 * itemId,RestaurantId,itemName<ItemPrice,quantity.
	 * 
	 * @Response Body :- Return Items which contains -
	 * itemId,RestaurantId,itemName<ItemPrice,quantity.
	 * 
	 * 
	 */

	@PutMapping("/items")
	public ResponseEntity<?> updateItem(@RequestBody Items item) {
		Items temp = null;
		try {
			UsersRequestBodyValidation.validateItemField(item.getRestaurantId(), item.getItemName(),
					item.getItemPrice());
			temp = this.itemService.updateItem(item);
			logger.info("update Item successfully");
			return new ResponseEntity<>(temp, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
		}

	}

	/*
	 * This API is responsible for deleteItem of restaurant details in application
	 * 
	 * @RequestBody :- itemId
	 * 
	 * @Response Body :- Return message Item deleted successfully.
	 * 
	 * 
	 */
	@DeleteMapping("/items/{itemId}")
	public ResponseEntity<HttpStatus> deleteItem(@PathVariable int itemId) {
		try {
			UsersRequestBodyValidation.validateItemName(itemId);
			this.itemService.deleteItem(itemId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

}
