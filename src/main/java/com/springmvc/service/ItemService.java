package com.springmvc.service;

import java.util.List;

import com.springmvc.model.Item;

public interface ItemService{
	Item findById(Integer id);
	
	void saveItem(Item item);
	
	void updateItem(Item item);
	
	void deleteItemById(Integer id);
	
	List<Item> findAllItems();

}