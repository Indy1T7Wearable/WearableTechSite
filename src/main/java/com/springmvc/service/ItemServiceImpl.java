package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.ItemDao;
import com.springmvc.model.Item;

@Service("itemService")
@Transactional
public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemDao dao;
	
	public Item findById(Integer id) {
		return dao.findById(id);
	}

	public void saveItem(Item item) {
		dao.save(item);		
	}

	public void updateItem(Item item) {
		Item entity = dao.findById(item.getId());
		if(entity!=null){
			entity.setName(item.getName());
			entity.setBrand(item.getBrand());
			entity.setPrice(item.getPrice());
			entity.setItemTypes(item.getItemTypes());
		}
	}

	public void deleteItemById(Integer id) {
		dao.deleteById(id);
	}

	public List<Item> findAllItems() {
		return dao.findAllItems();
	}
	
}

