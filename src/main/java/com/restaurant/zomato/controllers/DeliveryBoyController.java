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

import com.restaurant.zomato.entities.DeliveryBoy;
import com.restaurant.zomato.services.DeliveryBoyService;
import com.restaurant.zomato.validation.UsersRequestBodyValidation;

@RestController
@CrossOrigin(origins = { "http://localhost:3000" })
public class DeliveryBoyController {

	Logger logger = LoggerFactory.getLogger(DeliveryBoyController.class);
	@Autowired
	private DeliveryBoyService deliveryBoyService;

	/*
	 * This API is responsible for fetching all DeliveryBoy Records from Database
	 * 
	 * @RequestBody :- NA
	 * 
	 * @Response Body :- Return List Of DeliveryBoy, who have registered in
	 * application successfully.
	 * 
	 * 
	 */
	@GetMapping("/deliveries")
	public ResponseEntity<?> getAllDeliveryBoy() {
		List<DeliveryBoy> temp = null;
		try {
			temp = this.deliveryBoyService.getAllDeliveryBoy();
			if (temp.size() == 0)
				throw new Exception("delivery Boy not found");
			else
				logger.info("deliveryBoy Found");
			return new ResponseEntity<>(temp, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
		}

	}

	/*
	 * This API is responsible for fetching one DeliveryBoy detail Records from
	 * Database
	 * 
	 * @RequestBody :- deliveryBoyId
	 * 
	 * @Response Body :- Return deliveryBoy which contains -
	 * name,deliveryBoyId,address,RestaurantId, , who have registered in application
	 * successfully.
	 * 
	 * 
	 */

	@GetMapping("/deliveries/{deliveryBoyId}")
	public ResponseEntity<?> getOneDeliveryBoy(@PathVariable int deliveryBoyId) {
		DeliveryBoy boy = null;
		try {
			UsersRequestBodyValidation.validateDeliveryBoyId(deliveryBoyId);
			boy = this.deliveryBoyService.getOneDeliveryBoy(deliveryBoyId);
			logger.info("deliveryBoy found successfully");
			return new ResponseEntity<>(boy, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
		}

	}

	/*
	 * This API is responsible for Add deliveryBoy in application
	 * 
	 * @RequestBody :- DeliveryBoy which contains -
	 * name,deliveryBoyId,address,RestaurantId.
	 * 
	 * @Response Body :- Return DeliveryBoy which contains
	 * -name,deliveryBoyId,address,RestaurantId.
	 * 
	 * 
	 */

	@PostMapping("/deliveries")
	public ResponseEntity<?> addDeliveryBoy(@RequestBody DeliveryBoy deliveryBoy) {
		DeliveryBoy boy = null;
		try {
			UsersRequestBodyValidation.validateDeliveryBoyField(deliveryBoy.getDeliveryBoyId(),
					deliveryBoy.getRestaurantId(), deliveryBoy.getAddress());
			boy = this.deliveryBoyService.addDeliveryBoy(deliveryBoy);
			logger.info("deliveryBoy added successfully");
			return new ResponseEntity<>(boy, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);

		}

	}

	/*
	 * This API is responsible for updateDeliveryBoy details in application
	 * 
	 * @RequestBody :- DeliveryBoy which contains -
	 * name,deliveryBoyId,address,RestaurantId.
	 * 
	 * @Response Body :- Return Restaurant which contains -
	 * name,deliveryBoyId,address,RestaurantId.
	 * 
	 * 
	 */

	@PutMapping("/deliveries")
	public ResponseEntity<?> updateDeliveryBoy(@RequestBody DeliveryBoy deliveryBoy) {
		DeliveryBoy boy = null;
		try {
			UsersRequestBodyValidation.validateDeliveryBoyField(deliveryBoy.getRestaurantId(),
					deliveryBoy.getDeliveryBoyId(), deliveryBoy.getAddress());
			boy = this.deliveryBoyService.updateDeliveryBoy(deliveryBoy);
			logger.info("updated deliveryBoy");
			return new ResponseEntity<>(boy, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);

		}

	}

	/*
	 * This API is responsible for deleteDeliveryBoy details in application
	 * 
	 * @RequestBody :- deliveryBoyId
	 * 
	 * @Response Body :- Return message deliveryBoy deleted successfully.
	 * 
	 * 
	 */

	@DeleteMapping("/deliveries/{deliveriesId}")
	public ResponseEntity<HttpStatus> deleteDeliveryBoy(@PathVariable int deliveryBoyId) {
		try {
			UsersRequestBodyValidation.validateDeliveryBoyId(deliveryBoyId);
			this.deliveryBoyService.deleteDeliveryBoy(deliveryBoyId);
			logger.info("deleted deliveryBoy successfully");
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

}
