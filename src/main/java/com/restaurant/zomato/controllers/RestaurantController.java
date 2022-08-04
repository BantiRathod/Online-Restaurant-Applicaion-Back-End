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

import com.restaurant.zomato.entities.Restaurant;
import com.restaurant.zomato.services.RestaurantService;
import com.restaurant.zomato.validation.UsersRequestBodyValidation;

@RestController
@CrossOrigin(origins = { "http://localhost:3000" })
public class RestaurantController {
	@Autowired
	private RestaurantService restaurantService;
	Logger logger = LoggerFactory.getLogger(RestaurantController.class);

	/*
	 * This API is responsible for fetching all Restaurant Records from Database
	 * 
	 * @RequestBody :- NA
	 * 
	 * @Response Body :- Return List Of Restaurants, who have registered in
	 * application successfully.
	 * 
	 * 
	 */
	@GetMapping("/restaurants")
	public ResponseEntity<?> getAllRestaurant() {
		List<Restaurant> restaurant = null;
		try {

			restaurant = this.restaurantService.getAllRestaurant();
			if (restaurant.size() == 0)
				throw new Exception("not found any Restaurant");
			else
				logger.info("Data found");

			return new ResponseEntity<>(restaurant, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			logger.error("Exception occured, {}", e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
		}

	}

	/*
	 * This API is responsible for fetching one Restaurant detail Records from
	 * Database
	 * 
	 * @RequestBody :- restaurantId
	 * 
	 * @Response Body :- Return Restaurant , who have registered in application
	 * successfully.
	 * 
	 * 
	 */

	@GetMapping("/restaurants/{restaurantId}")
	public ResponseEntity<?> getOneRestaurant(@PathVariable int restaurantId) {
		Restaurant temp = null;
		try {
			UsersRequestBodyValidation.validateRestaurantId(restaurantId);
			temp = restaurantService.getOneRestaurantById(restaurantId);
			logger.info("user details found");
			return new ResponseEntity<>(temp, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			logger.error("Exception occured, {}", e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);

		}

	}

	/*
	 * This API is responsible for fetching all Restaurant detail for the help of
	 * address Records from Database
	 * 
	 * @RequestBody :- restaurantLocation
	 * 
	 * @Response Body :- Return List Of Restaurant , who have registered in
	 * application successfully.
	 * 
	 * 
	 */

	@GetMapping("/address/{restaurantLocation}")
	public ResponseEntity<?> getAllRestaurant(@PathVariable String restaurantLocation) {
		List<Restaurant> temp = null;
		try {
			UsersRequestBodyValidation.validateRestaurantByLocation(restaurantLocation);
			temp = restaurantService.getAllRestaurantByAdd(restaurantLocation);
			logger.info("restaurant details found");
			return new ResponseEntity<>(temp, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);

		}

	}

	/*
	 * This API is responsible for Add restaurant in application
	 * 
	 * @RequestBody :- Restaurant which contains - restaurantId,name,address
	 * 
	 * @Response Body :- Return Restaurant which contains -
	 * restaurantId,name,address.
	 * 
	 * 
	 */
	@PostMapping("/restaurants")
	public ResponseEntity<?> addRestaurant(@RequestBody Restaurant restaurant) {
		Restaurant temp = null;
		try {
			UsersRequestBodyValidation.validateRestaurantId(restaurant.getRestaurantId());
			temp = restaurantService.addRestaurant(restaurant);
			logger.info("restaurant added successfully");
			return new ResponseEntity<>(temp, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
		}

	}

	/*
	 * This API is responsible for updateRestaurant details in application
	 * 
	 * @RequestBody :- Restaurant which contains - restaurantId,name,address
	 * 
	 * @Response Body :- Return Restaurant which contains -
	 * restaurantId,name,address.
	 * 
	 * 
	 */
	@PutMapping("/restaurants")
	public ResponseEntity<?> updateRestaurant(@RequestBody Restaurant restaurant) {
		Restaurant temp = null;
		try {
			UsersRequestBodyValidation.validateRestaurantId(restaurant.getRestaurantId());
			temp = restaurantService.addRestaurant(restaurant);
			logger.info("Update restaurant Successfully");
			return new ResponseEntity<>(temp, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
		}

	}

	/*
	 * This API is responsible for deleteRestaurant details in application
	 * 
	 * @RequestBody :- restaurantId
	 * 
	 * @Response Body :- Return message restaurant deleted successfully.
	 * 
	 * 
	 */
	@DeleteMapping("/restaurants/{restaurantId}")
	public ResponseEntity<?> deleteRestaurant(@PathVariable int restaurantId) {
		try {
			UsersRequestBodyValidation.validateRestaurantId(restaurantId);
			this.restaurantService.deleteRestaurant(restaurantId);
			logger.info("restaurant Deleted successfully");
			return new ResponseEntity<String>("Restaurant has been deleted successfully", HttpStatus.OK);
		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<String>("Restaurant has not been deleted", HttpStatus.NOT_FOUND);

		}

	}

}