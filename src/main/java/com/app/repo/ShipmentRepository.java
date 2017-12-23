package com.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.app.model.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment, Long>,JpaSpecificationExecutor<Shipment> {
	List<Shipment> findByShmnt(String shmnt);

}
