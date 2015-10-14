package com.springmvc.model;

public enum ItemItemType{
	ITEM("ITEM"),
	SPORT("SPORT"),
	LUXURY("LUXURY"),
	SMART("SMART");
	
	String itemItemType;
	
	private ItemItemType(String itemItemType){
		this.itemItemType = itemItemType;
	}
	
	public String getItemItemType(){
		return itemItemType;
	}
}