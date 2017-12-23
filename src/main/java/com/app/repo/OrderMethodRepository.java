package com.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.app.model.OrderMethod;

/**
 * @author Munisekhar Gunapati
 */
public interface OrderMethodRepository extends JpaRepository<OrderMethod, Long>,JpaSpecificationExecutor<OrderMethod> {
	List<String> findByOrderMode(String orderMode);

}
