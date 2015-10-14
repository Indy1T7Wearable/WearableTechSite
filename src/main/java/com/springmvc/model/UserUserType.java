package com.springmvc.model;

public enum UserUserType{
	USER("USER"),
	ADMIN("ADMIN");
	
	String userUserType;
	
	private UserUserType(String userUserType){
		this.userUserType = userUserType;
	}
	
	public String getUserUserType(){
		return userUserType;
	}
}