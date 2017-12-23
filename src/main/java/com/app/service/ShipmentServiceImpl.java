package com.app.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Shipment;
import com.app.repo.ShipmentRepository;

/**
 * @author Munisekhar Gunapati
 */
@Service
public class ShipmentServiceImpl implements IShipmentService {
	@Autowired
	private ShipmentRepository repo;

	@Override
	public long saveShipment(Shipment shipment) {
		shipment.setCreatedDate(new Date());
		shipment=repo.save(shipment);
		return shipment.getShipmentId();
	}

	@Override
	public List<Shipment> getAll() {
		List<Shipment> shipmentList=repo.findAll();
		Collections.sort(shipmentList);
		return shipmentList;
	}
	@Override
	public Shipment getShipmentById(long shipmentId) {
		Shipment shipment1=repo.getOne(shipmentId);
		return shipment1;
	}

	@Override
	public void updateShipment(Shipment shipment) {
		shipment.setCreatedDate(repo.getOne(shipment.getShipmentId()).getCreatedDate());
		shipment.setLastmodifiedDate(new Date());
		repo.save(shipment);
	}

	@Override
	public void deleteShipmentById(long shipmentId) {
		repo.delete(shipmentId);
	}

	@Override
	public List<Shipment> findByShmnt(String shmnt) {
		return repo.findByShmnt(shmnt);
	}
}
