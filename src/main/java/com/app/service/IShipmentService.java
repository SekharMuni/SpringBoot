package com.app.service;

import java.util.List;

import com.app.model.Shipment;

public interface IShipmentService {
	
	long saveShipment(Shipment shipment);
	public void updateShipment(Shipment shipment);
	public void deleteShipmentById(long shipmentId);
	
	public List<Shipment> getAll();
	public Shipment getShipmentById(long shipmentId);
	List<Shipment> findByShmnt(String shmnt);

}
