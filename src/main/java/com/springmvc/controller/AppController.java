package com.springmvc.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springmvc.model.Item;
import com.springmvc.model.ItemType;
import com.springmvc.service.ItemTypeService;
import com.springmvc.service.ItemService;

@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class AppController{
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	ItemTypeService itemTypeService;
	
	@Autowired
	MessageSource messageSource;
	
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listItems(ModelMap model){
		
		List<Item> items = itemService.findAllItems();
		model.addAttribute("items", items);
		return "itemlist";
	}
	
	
	@RequestMapping(value = { "/newitem" }, method = RequestMethod.GET )
	public String newItem(ModelMap model){
		Item item = new Item();
		model.addAttribute("item", item);
		model.addAttribute("edit", false);
		return "registration";
	}
	
	@RequestMapping(value = { "/newitem" }, method = RequestMethod.POST)
	public String saveItem(@Valid Item item, BindingResult result, ModelMap model){
		if(result.hasErrors()){
			return "registration";
		}
		
		itemService.saveItem(item);
		
		model.addAttribute("success", "Item " + item.getName() + " from " + item.getBrand() + " registered successfully");
		return "registrationsuccess";
	}
	
	@RequestMapping(value = {"/edit-item-{id}" }, method = RequestMethod.GET)
	public String editItem(@PathVariable Integer id, ModelMap model){
		Item item = itemService.findById(id);
		model.addAttribute("item", item);
		model.addAttribute("edit", true);
		
		return "registration";
	}
	
	@RequestMapping(value = {"/edit-item-{id}" }, method = RequestMethod.POST)
	public String updateItem(@Valid Item item, BindingResult result, ModelMap model, @PathVariable Integer id){
		if(result.hasErrors()){
			return "registration";
		}
		
		itemService.updateItem(item);
		
		model.addAttribute("success", "Item " + item.getName() + " from " + item.getBrand() + " updated successfully");
		return "registrationsuccess";
	}
	
	@RequestMapping(value = { "/delete-item-{id}" }, method = RequestMethod.GET)
	public String deleteItem(@PathVariable Integer id){
		itemService.deleteItemById(id);
		return "redirect:/list";
	}
	
	@ModelAttribute("roles")
	public List<ItemType> initializeTypes(){
		return itemTypeService.findAll();
	}
}