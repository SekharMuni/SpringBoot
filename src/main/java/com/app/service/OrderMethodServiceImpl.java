package com.app.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.OrderMethod;
import com.app.repo.OrderMethodRepository;

/**
 * @author Munisekhar Gunapati
 */
@Service
public class OrderMethodServiceImpl implements IOrderMethodService {
	@Autowired
	private OrderMethodRepository repo;

	@Override
	public long saveOrderMethod(OrderMethod orderMethod) {
		orderMethod.setCreatedDate(new Date());
		 orderMethod=repo.save(orderMethod);
		return orderMethod.getOrderMethodId();
	}
	@Override
	public void deleteOrderMethodbyId(long orderMethodId) {
		repo.delete(orderMethodId);
	}

	@Override
	public void updateOrderMethod(OrderMethod orderMethod) {
		orderMethod.setCreatedDate(repo.getOne(orderMethod.getOrderMethodId()).getCreatedDate());
		orderMethod.setLastModifiedDate(new Date());
		repo.save(orderMethod);
	}

	@Override
	public OrderMethod getOneOrderMethod(long orderMethodId) {
		OrderMethod orderMethod=repo.getOne(orderMethodId);
		return orderMethod;
	}

	@Override
	public List<OrderMethod> getall() {
		List<OrderMethod> orderMethodList=repo.findAll();
		Collections.sort(orderMethodList);
		return orderMethodList;
	}
	@Override
	public List<String> findByOrderMode(String orderMode) {
		return repo.findByOrderMode(orderMode);
	}
}
