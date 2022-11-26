package com.orderparser.model;

public class OutputData {
	
	private static Integer counter = 1;
	
	private Integer id;
	
	private Integer orderId;
	
	private Float amount;
	
	private String comment;
	
	private String fileName;
	
	private Integer line;
	
	private String result;

	public OutputData(Integer orderId, Float amount, String comment, String fileName, Integer line, String result) {
		super();
		this.id = getIdValue();
		this.orderId = orderId;
		this.amount = amount;
		this.comment = comment;
		this.fileName = fileName;
		this.line = line;
		this.result = result;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getLine() {
		return line;
	}

	public void setLine(Integer line) {
		this.line = line;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	private Integer getIdValue()
	{
		return counter ++;
	}
	@Override
	public String toString() {
		return "{id=" + id + ", orderId=" + orderId + ", amount=" + amount + ", comment=" + comment
				+ ", fileName=" + fileName + ", line=" + line + ", result=" + result + "}";
	}
	
	

}
