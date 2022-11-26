package com.orderparser.model;

public class Order {
	
	private Integer orderId;
	
	private Float amount;
	
	private String currency;
	
	private String comment;

	
	public Order() {
		super();
	}

	public Order(Integer orderId, Float amount, String currency, String comment) {
		super();
		this.orderId = orderId;
		this.amount = amount;
		this.currency = currency;
		this.comment = comment;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
