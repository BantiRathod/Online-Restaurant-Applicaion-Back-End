package com.restaurant.zomato.controllers;

import java.util.List;

import com.restaurant.zomato.dto.OrderRequestBody;
import com.restaurant.zomato.dto.PlacedOrder;
import com.restaurant.zomato.dto.PreviewOrder;

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

import com.restaurant.zomato.entities.Cart;
import com.restaurant.zomato.entities.UserOrders;
import com.restaurant.zomato.services.OrderService;
import com.restaurant.zomato.validation.UsersRequestBodyValidation;

@RestController
@CrossOrigin(origins = { "http://localhost:3000" })
public class OrderController {
	Logger logger = LoggerFactory.getLogger(OrderController.class);
	@Autowired
	private OrderService orderService;

	/*
	 * This API is responsible for fetching all UserOrders Records from Database
	 * 
	 * @RequestBody :- NA
	 * 
	 * @Response Body :- Return List Of userOrders, who have registered in
	 * application successfully.
	 * 
	 * 
	 */
	@GetMapping("/orders")
	public ResponseEntity<?> getAllOrder() {
		List<UserOrders> temp = null;
		try {
			temp = this.orderService.getAllOrder();
			if (temp.size() == 0)
				throw new Exception("not found any Order");
			else
				logger.info("Data found");

			return new ResponseEntity<>(temp, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			logger.info(e.getMessage());

			return new ResponseEntity<>(e.getMessage(), HttpStatus.ACCEPTED);

		}

	}

	/*
	 * This API is responsible for fetching oneUserOrder detail Records from
	 * Database
	 * 
	 * @RequestBody :- orderId
	 * 
	 * @Response Body :- Return UserOrders which contains -
	 * orderId,userId,restaurantId,deliveryBoyId,orderStatus,amount,date,
	 * transactionId,cartId, who have ordered in application successfully.
	 * 
	 */

	@GetMapping("/orders/{orderId}")
	public ResponseEntity<?> getOneOrder(@PathVariable int orderId) {
		UserOrders temp = null;
		try {
			UsersRequestBodyValidation.validateOrderId(orderId);
			temp = this.orderService.getOneOrder(orderId);
			logger.info("order detail found");
			return new ResponseEntity<>(temp, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);

		}

	}

	/*
	 * This API is responsible for updaetUserOrder details in application
	 * 
	 * 
	 * @Request Body :- UserOrders which contains -
	 * orderId,userId,restaurantId,deliveryBoyId,orderStatus,amount,date,
	 * transactionId,cartId.
	 * 
	 * 
	 * @Response Body :- Return UserOrders which contains -
	 * orderId,userId,restaurantId,deliveryBoyId,orderStatus,amount,date,
	 * transactionId,cartId, who have ordered in application successfully.
	 * 
	 */
	@PutMapping("/orders")
	public ResponseEntity<?> updateOrder(@RequestBody UserOrders order) {

		UserOrders temp = null;
		try {
			temp = this.orderService.updateOrder(order);
			logger.info("order updated successfully");
			return new ResponseEntity<>(temp, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);

		}

	}

	/*
	 * This API is responsible for deleteUserOrder details in application
	 * 
	 * @RequestBody :- orderId
	 * 
	 * @Response Body :- Return message userOrder deleted successfully.
	 * 
	 * 
	 */

	@DeleteMapping("/orders/{orderId}")
	public ResponseEntity<?> deleteOrder(@PathVariable int orderId) {
		try {
			this.orderService.deleteOrder(orderId);
			logger.info("user order deleted successfully");
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	/*
	 * This API is responsible for OrderPLaced in application
	 * 
	 * @RequestBody :- OrderRequestBody which contains -
	 * cartId,phoneNumber,restaurantId,amount.
	 * 
	 * @Response Body :- Return UserOrders which contains -
	 * orderId,userId,restaurantId,deliveryBoyId,orderStatus,amount,date,
	 * transactionId,cartId, who have ordered in application successfully.
	 * 
	 */

	@PostMapping("order/placeorder")
	public ResponseEntity<?> confirmOrder(@RequestBody OrderRequestBody orderRequestBody) {
		UserOrders pp;
		try {
			pp = orderService.confirmOrder(orderRequestBody);
			logger.info("order placed successfully");
			return new ResponseEntity<>(pp, HttpStatus.OK);
		} catch (Exception e) {

			logger.info(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
