package com.restaurant.zomato.controllers;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.zomato.dto.UserLoginResponseBody;
import com.restaurant.zomato.entities.LoginUser;
import com.restaurant.zomato.entities.UserOrders;
import com.restaurant.zomato.entities.Users;
import com.restaurant.zomato.services.UserService;
import com.restaurant.zomato.validation.UsersRequestBodyValidation;

@RestController
@Validated
@CrossOrigin(origins = { "http://localhost:3000" })
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	/*
	 * This API is responsible for fetching all Users Records from Database
	 * 
	 * @RequestBody :- NA
	 * 
	 * @Response Body :- Return List Of Users, who have registered in application
	 * successfully.
	 * 
	 * 
	 */
	@GetMapping("/users")
	public ResponseEntity<?> getAllUser() {
		List<Users> user = null;
		try {
			user = this.userService.getAllUser();

			if (user.size() == 0)
				throw new Exception("not found any user");
			else
				logger.info("Data found");

			return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
		} catch (Exception e) {
		
			logger.error("Exception occured, {}", e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
		}

	}

	/*
	 * This API is responsible for fetching one User detail Records from Database
	 * 
	 * @RequestBody :- userId
	 * 
	 * @Response Body :- Return User, who have registered in application
	 * successfully.
	 * 
	 * 
	 */

	@GetMapping("/users/{userId}")
	public ResponseEntity<?> getOneUser(@PathVariable long userId) {
		Users temp = null;
		try {
			UsersRequestBodyValidation.validateUserPhoneNumber(userId);
			temp = userService.getOneUser(userId);
			logger.info("user details found");
			return new ResponseEntity<>(temp, HttpStatus.ACCEPTED);

		} catch (Exception e) {

			logger.error("Exception occured, {}", e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
		}

	}

	/*
	 * This API is responsible for login user in application
	 * 
	 * @RequestBody :- LoginUser which contains - userId,userPassword
	 * 
	 * @Response Body :- Return UserLoginResponseBody which contains -
	 * status,statusCode,listFormat userLogiId and Password.
	 * 
	 * 
	 */

	@PostMapping("/login")
	public ResponseEntity<?> userLogin(@RequestBody LoginUser user) {
		UserLoginResponseBody temp = null;
		try {
			UsersRequestBodyValidation.validateUserPhoneNumber(user.getPhoneNumber());
			temp = this.userService.userAuthentication(user.getPhoneNumber(), user.getPassword());
			logger.info("user login successfully");
			return new ResponseEntity<>(temp, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			logger.error("Exception occured, {}", e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
		}

	}

//	@PostMapping("/headertest")
//	public  String headerTest(@RequestHeader Map<String, String> h, @RequestBody String s) {
//			
//			h.forEach((key, value) -> {
//				System.out.println(key +" : "+value);
//			});
//			
//			
//			return "";
//	}

	/*
	 * This API is responsible for SignUp user in application
	 * 
	 * @RequestBody :- Users which contains - name,phoneNumber,password
	 * 
	 * @Response Body :- Return Users which contains - name,phoneNumber,password.
	 * 
	 * 
	 */

	@PostMapping("/signup")
	public ResponseEntity<?> addUser(@RequestBody Users user) {

		Users temp = null;
		try {
			logger.info("Received user {}", user);
			UsersRequestBodyValidation.validateUserPhoneNumber(user.getPhoneNumber());
			temp = this.userService.addUser(user);
			logger.info("user saved");
			return new ResponseEntity<>(temp, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
		}

	}

	/*
	 * This API is responsible for updateUser details in application
	 * 
	 * @RequestBody :- Users which contains - name,phoneNumber,password
	 * 
	 * @Response Body :- Return Users which contains - name,phoneNumber,password.
	 * 
	 * 
	 */

	@PutMapping("/users")
	public ResponseEntity<?> updateUser(@RequestBody Users user) {
		Users temp = null;
		try {
			UsersRequestBodyValidation.validateUserPhoneNumber(user.getPhoneNumber());
			temp = this.userService.updateUser(user);
			logger.info("user updated successfully");
			return new ResponseEntity<>(temp, HttpStatus.ACCEPTED);

		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
		}

	}

	/*
	 * This API is responsible for deleteUser details in application
	 * 
	 * @RequestBody :- userId
	 * 
	 * @Response Body :- Return message user deleted successfully.
	 * 
	 * 
	 */

	@DeleteMapping("/users/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable long userId) {
		try {
			UsersRequestBodyValidation.validateUserPhoneNumber(userId);
			this.userService.deleteUser(userId);
			logger.info("user deleted successfully");
			return new ResponseEntity<>("user has been deleted successfully", HttpStatus.OK);
		} catch (Exception e) {
			logger.info(e.getMessage());
			return new ResponseEntity<>("user has not been deleted", HttpStatus.NOT_FOUND);

		}
	}

	/*
	 * This API is responsible for fetching placeOrder details Records from Database
	 * 
	 * @RequestBody :- phoneNumber,address,name
	 * 
	 * @Response Body :- Return UserOrders which contains -
	 * orderId,userId,restaurantId,deliveryBoyId,orderStatus,amount,date,
	 * transactionId,cartId, who have ordered in application successfully.
	 * 
	 * 
	 */

	@GetMapping("/placeorders/{phoneNumber}/{address}/{name}")
	public ResponseEntity<?> getPlaceOrder(@PathVariable long phoneNumber, @PathVariable String address,
			@PathVariable String name) {
		UserOrders entity = null;
		try {
			UsersRequestBodyValidation.validatePlaceOrderField(phoneNumber, address, name);
			entity = this.userService.getOrderPlaced(phoneNumber, address, name);
			logger.info("place order details found");
			return new ResponseEntity<>(entity, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			logger.info("not found details of placeOrder");
			return new ResponseEntity<>(e.getMessage(), HttpStatus.FAILED_DEPENDENCY);
		}

	}

}
