package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.ItemTypeDao;
import com.springmvc.model.ItemType;

@Service("itemTypeService")
@Transactional
public class ItemTypeServiceImpl implements ItemTypeService{
	
	@Autowired
	ItemTypeDao dao;
	
	public ItemType findById(Integer id){
		return dao.findById(id);
	}
	
	public ItemType findByType(String type){
		return dao.findByType(type);
	}
	
	public List<ItemType> findAll(){
		return dao.findAll();
	}
}