package com.restaurant.zomato.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Data
//@Table(name= "user", uniqueConstraints = @UniqueConstraint(columnNames = "phoneNumber"))
public class Users {
	@Column(name="name")
	private String name;
	@Id
	private long phoneNumber;
	private String password;
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(String name, long phoneNumber, String password) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Users [name=" + name + ", phoneNumber=" + phoneNumber + ", password=" + password + "]";
	}
	
	

}
