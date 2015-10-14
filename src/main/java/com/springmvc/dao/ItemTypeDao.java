package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.ItemType;

public interface ItemTypeDao{
	
	List<ItemType> findAll();
	
	ItemType findByType(String type);
	
	ItemType findById(Integer id);
}