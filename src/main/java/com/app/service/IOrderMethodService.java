/**
 * 
 */
package com.app.service;

import java.util.List;

import com.app.model.OrderMethod;

/**
 * @author Munisekhar Gunapati
 */
public interface IOrderMethodService {
	
	public long saveOrderMethod(OrderMethod orderMethod);
	
	public void deleteOrderMethodbyId(long orderMethodId);
	public void updateOrderMethod(OrderMethod orderMethod);
	
	public OrderMethod getOneOrderMethod(long orderMethodId);
	
	public List<OrderMethod> getall();
	
	List<String> findByOrderMode(String orderMode);

}
