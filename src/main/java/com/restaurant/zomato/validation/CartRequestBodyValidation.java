package com.restaurant.zomato.validation;

import java.util.List;

import com.restaurant.zomato.entities.Items;

public class CartRequestBodyValidation {

	public static void checkItemsList(List<Items> list) throws Exception
	{
		int totalQuantity=0;
		for( Items x : list)
    	{
    		totalQuantity +=x.getQuantity();
    	}
		
	    if(totalQuantity==0)
	    	throw new Exception("Quantity can not be zero");
	    
	}
}
