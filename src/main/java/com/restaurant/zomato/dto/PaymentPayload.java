package com.restaurant.zomato.dto;

public class PaymentPayload {
	private String senderUserId;
	private String receiverUserId;
	private long amount;
	public PaymentPayload() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaymentPayload(String senderUserId, String receiverUserId, long amount) {
		super();
		this.senderUserId = senderUserId;
		this.receiverUserId = receiverUserId;
		this.amount = amount;
	}
	public String getSenderUserId() {
		return senderUserId;
	}
	public void setSenderUserId(String senderUserId) {
		this.senderUserId = senderUserId;
	}
	public String getReceiverUserId() {
		return receiverUserId;
	}
	public void setReceiverUserId(String receiverUserId) {
		this.receiverUserId = receiverUserId;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "PaymentPayload [senderUserId=" + senderUserId + ", receiverUserId=" + receiverUserId + ", amount="
				+ amount + "]";
	}
	
}