package com.springmvc.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.springmvc.model.ItemType;
import com.springmvc.service.ItemTypeService;

@Component
public class RoleToItemTypeConverter implements Converter<Object, ItemType>{
	
	@Autowired
	ItemTypeService itemTypeService;
	
	public ItemType convert(Object element){
		Integer id = Integer.parseInt((String)element);
		ItemType item = itemTypeService.findById(id);
		System.out.println("Item : "+item);
		return item;
	}
}