package com.restaurant.zomato.dto;

import com.restaurant.zomato.entities.DeliveryBoy;
import lombok.Data;

@Data
public class PlacedOrder {
    private int orderId;
    private DeliveryBoy deliveryBoy;
    private PreviewOrder previewOrder;
    
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public DeliveryBoy getDeliveryBoy() {
		return deliveryBoy;
	}
	public void setDeliveryBoy(DeliveryBoy deliveryBoy) {
		this.deliveryBoy = deliveryBoy;
	}
	public PreviewOrder getPreviewOrder() {
		return previewOrder;
	}
	public void setPreviewOrder(PreviewOrder previewOrder) {
		this.previewOrder = previewOrder;
	}
    
    
}
