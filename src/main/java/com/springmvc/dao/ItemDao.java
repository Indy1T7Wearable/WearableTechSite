package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.Item;

public interface ItemDao{
	
	Item findById(Integer id);
	
	void save(Item item);
	
	void deleteById(Integer id);
	
	List<Item> findAllItems();
}