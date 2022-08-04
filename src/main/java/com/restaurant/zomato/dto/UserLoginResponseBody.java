package com.restaurant.zomato.dto;

import java.util.ArrayList;

import lombok.Data;

@Data
public class UserLoginResponseBody {

	private ArrayList<LoginResult> res;
	private String status;
	private int statusCode;
	
	public ArrayList<LoginResult> getRes() {
		return res;
	}
	public void setRes( ArrayList<LoginResult>res) {
		this.res = res;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	} 
	
	
	
	
}
