package com.app.service;

import java.util.List;

import com.app.model.WhUserType;

/**
 * @author Munisekhar Gunapati
 */
public interface IWhUserTypeService {
	
	public long saveWhUserType(WhUserType whUserType);
	
	public void updateWhUserType(WhUserType whUserType);
	public void deleteWhUserType(long whUserTypeId);
	
	public WhUserType getOneWhUserTypeId(long whUserTypeId );
	public List<WhUserType> getAll();
	public List<WhUserType> findByUserType(String userType);

}
