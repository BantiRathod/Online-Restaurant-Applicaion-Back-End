package com.restaurant.zomato.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.zomato.dto.CartResponseBody;
import com.restaurant.zomato.entities.CartInfo;
import com.restaurant.zomato.entities.Items;
import com.restaurant.zomato.services.CartService;
import com.restaurant.zomato.validation.CartRequestBodyValidation;
import com.restaurant.zomato.validation.UsersRequestBodyValidation;

@RestController
@CrossOrigin(origins = { "http://localhost:3000" })
public class CartController {

	Logger logger = LoggerFactory.getLogger(CartController.class);

	@Autowired
	private CartService cartService;

	/*
	 * This API is responsible for AddItem in to Cart in application
	 * 
	 * @RequestBody :- phoneNumber,listOfItem which contains -
	 * restaurantId,name,address
	 * 
	 * @Response Body :- Return CartResponseBody which contains -
	 * userId,CartId,ListOfItem,totalAmount.
	 * 
	 * 
	 */

	@PostMapping("/addtocart/{phoneNumber}")
	public ResponseEntity<?> addCart(@PathVariable long phoneNumber, @RequestBody List<Items> selectedItem)
			throws Exception {
		CartResponseBody CartResponseBody = null;

		try {

			CartRequestBodyValidation.checkItemsList(selectedItem);
			CartResponseBody = cartService.saveCart(phoneNumber, selectedItem);
			logger.info("AddCart to item Successfully");
			return new ResponseEntity<>(CartResponseBody, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			logger.error("Error : {}", e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*
	 * This API is responsible for fetching CartItem detail for the help of
	 * PhoneNumber Records from Database
	 * 
	 * @RequestBody :- PhoneNumber
	 * 
	 * @Response Body :- Return List Of Item , who have registered in application
	 * successfully.
	 * 
	 * 
	 */
	@GetMapping("/getcartitem/{phoneNumber}")
	public ResponseEntity<?> getAllSelectedItemByPhoneNumber(@PathVariable long phoneNumber) {
		List<Items> temp = null;
		try {
			UsersRequestBodyValidation.validateUserPhoneNumber(phoneNumber);
			temp = this.cartService.getAllItemByPhoneNumber(phoneNumber);
			logger.info("get cart item details successfully");
			return new ResponseEntity<>(temp, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);

		}

	}
	
	@PutMapping("/updatecartitem/")
	public ResponseEntity<?> updateCartItem(@RequestBody CartInfo cartInfo){
		CartInfo temp=null;
		try {
			UsersRequestBodyValidation.validateCartId(cartInfo.getCartId());
			temp=this.cartService.updateCart(cartInfo);
			logger.info("update CartInfo details successfully");
			return new ResponseEntity<>(temp,HttpStatus.ACCEPTED);
		}catch(Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<>(e.getMessage(),HttpStatus.FAILED_DEPENDENCY);
		}
		
	}

}