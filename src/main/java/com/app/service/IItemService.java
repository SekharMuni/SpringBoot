package com.app.service;

import java.util.List;

import com.app.model.Item;

/**
 * @author Munisekhar Gunapati
 */
public interface IItemService {
	public long saveItem(Item item);
	public void deleteByItemId(long itemId);
	public void updateItem(Item item);
	
	public Item getOneByItemId(long itemId);
	public List<Item> getAll();
	
	public List<Item> findItemsByVendor(Long vendorId);


}
