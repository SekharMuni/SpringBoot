package com.app.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Item;
import com.app.repo.ItemRepository;

/**
 * @author Munisekhar Gunapati
 */
@Service
public class ItemServiceImpl implements IItemService {
	@Autowired
	private ItemRepository repo;

	@Override
	public long saveItem(Item item) {
		item.setCreatedDate(new Date());
		item=repo.save(item);
		return item.getItemId();
	}
	
	@Override
	public void deleteByItemId(long itemId) {
		repo.delete(itemId);
	}

	@Override
	public void updateItem(Item item) {
		item.setCreatedDate(repo.getOne(item.getItemId()).getCreatedDate());
		item.setLastModifiedDate(new Date());
		repo.save(item);
	}

	@Override
	public Item getOneByItemId(long itemId) {
		Item item=repo.getOne(itemId);
		return item;
	}
	@Override
	public List<Item> getAll() {
		List<Item> itemList=repo.findAll();
		Collections.sort(itemList);
		return itemList;
	}

	@Override
	public List<Item> findItemsByVendor(Long vendorId) {
		return repo.findItemsByVendor(vendorId);
	}

}
