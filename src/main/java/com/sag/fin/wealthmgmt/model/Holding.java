package com.sag.fin.wealthmgmt.model;

public class Holding {
	private String fundName;
	private int percentage;
	private int value;
	public String getFundName() {
		return fundName;
	}
	public void setFundName(String fundName) {
		this.fundName = fundName;
	}
	public int getPercentage() {
		return percentage;
	}
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Holding(String fundName, int percentage, int value) {
		super();
		this.fundName = fundName;
		this.percentage = percentage;
		this.value = value;
	}

}
