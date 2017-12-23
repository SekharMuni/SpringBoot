package com.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.app.model.PurchaseOrder;

/**
 * @author Munisekhar Gunapati
 */

public interface IPurchaseOrderService {
	
	long save(PurchaseOrder po);
	void update(PurchaseOrder po);
	void deleteById(long poId);
	
	PurchaseOrder getOneById(long poId);
	List<PurchaseOrder> getAll();
	List<PurchaseOrder> saveMultiple(List<PurchaseOrder> list);
	
	Page<PurchaseOrder> getAll(Specification<PurchaseOrder> s,Pageable pageable);

	

}
