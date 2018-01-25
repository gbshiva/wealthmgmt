package com.sag.fin.wealthmgmt.model;

public class ApiResponse {
	private String status;
	private String message;
	private String refNum;
	private Object requesObject;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getRefNum() {
		return refNum;
	}
	public void setRefNum(String refNum) {
		this.refNum = refNum;
	}
	public Object getRequesObject() {
		return requesObject;
	}
	public void setRequesObject(Object requesObject) {
		this.requesObject = requesObject;
	}
	public ApiResponse(String status, String message, String refNum, Object requesObject) {
		super();
		this.status = status;
		this.message = message;
		this.refNum = refNum;
		this.requesObject = requesObject;
	}
	

}
