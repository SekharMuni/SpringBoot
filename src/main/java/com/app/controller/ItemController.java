package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Item;
import com.app.service.IItemService;
import com.app.util.ItemUtil;

/**
 * @author Munisekhar Gunapati
 */
@Controller
public class ItemController {
	
	@Autowired
	private IItemService service;
	@Autowired
	private ItemUtil util;
	
	@GetMapping("/regItem")
	public String showItem(@ModelAttribute Item item,ModelMap map){
		map.addAttribute("item", item);
		util.getAllDynamics(map);
		return "ItemRegister";
	}
	@PostMapping("/insertItem")
	public String saveItem(@ModelAttribute Item item,BindingResult errors,ModelMap map){
		long id=service.saveItem(item);
		map.addAttribute("item", item);
		util.getAllDynamics(map);
		map.addAttribute("message","Item saved("+id+") Successfully");
		return "ItemRegister";
	}
	
	@GetMapping("/deleteItem")
	public String deleteItem(@RequestParam("itemId") long itemId){
		service.deleteByItemId(itemId);
		return "redirect:getAllItems";
	}
	
	@GetMapping("/editItem")
	public String editItem(@RequestParam("itemId") long itemId,ModelMap map){
		Item it=service.getOneByItemId(itemId);
		map.addAttribute("item", it);
		util.getAllDynamics(map);
		return "ItemDataEdit";
		
	}
	@PostMapping("/updateItem")
	public String updateItem(@ModelAttribute Item item,BindingResult errors,ModelMap map){
		service.saveItem(item);
		map.addAttribute("item", item);
		return "redirect:getAllItems";
	}
	@GetMapping("/getAllItems")
	public String getItems(@ModelAttribute Item item,ModelMap map){
		List<Item> itemList=service.getAll();
		map.addAttribute("items", itemList);
		return "ItemData";
		
	}
}
