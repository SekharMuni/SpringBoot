package com.app.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.app.model.PurchaseOrder;
import com.app.repo.PurchaseOrderRepository;

/**
 * @author Munisekhar Gunapati
 */
@Service
public class PurchaseOrderServiceImpl implements IPurchaseOrderService {
	
	@Autowired
	private PurchaseOrderRepository repo;

	@Override
	public long save(PurchaseOrder po) {
		po.setCreatedDate(new Date());
		po=repo.save(po);
		return po.getPoId();
	}

	@Override
	public void update(PurchaseOrder po) {
		po.setCreatedDate(repo.getOne(po.getPoId()).getCreatedDate());
		po.setLastModifiedDate(new Date());
		repo.save(po);
	}
	
	@Override
	public void deleteById(long poId) {
		repo.delete(poId);

	}

	@Override
	public PurchaseOrder getOneById(long poId) {
		return repo.getOne(poId);
	}

	@Override
	public List<PurchaseOrder> getAll() {
		List<PurchaseOrder> pList=repo.findAll();
		Collections.sort(pList);
		return pList;
	}

	@Override
	public List<PurchaseOrder> saveMultiple(List<PurchaseOrder> list) {
		return repo.findAll();
	}

	@Override
	public Page<PurchaseOrder> getAll(Specification<PurchaseOrder> s, Pageable pageable) {
		Page<PurchaseOrder> list=repo.findAll(s,pageable);
		return list;
	}

}
