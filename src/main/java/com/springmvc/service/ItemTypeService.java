package com.springmvc.service;

import java.util.List;

import com.springmvc.model.ItemType;

public interface ItemTypeService{
	
	ItemType findById(Integer id);
	
	ItemType findByType(String type);
	
	List<ItemType> findAll();
}