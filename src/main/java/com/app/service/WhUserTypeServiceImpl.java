package com.app.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.WhUserType;
import com.app.repo.WhUserTypeRepository;

/**
 * @author Munisekhar Gunapati
 */
@Service
public class WhUserTypeServiceImpl implements IWhUserTypeService {
	@Autowired
	private WhUserTypeRepository repo;

	@Override
	public long saveWhUserType(WhUserType whUserType) {
		whUserType.setCreatedDate(new Date());
		whUserType=(WhUserType)repo.save(whUserType);
		return whUserType.getWhUserTypeId();
	}

	@Override
	public void updateWhUserType(WhUserType whUserType) {
		whUserType.setCreatedDate(repo.getOne(whUserType.getWhUserTypeId()).getCreatedDate());
		whUserType.setLastModifiedDate(new Date());
		repo.save(whUserType);
	}

	@Override
	public void deleteWhUserType(long whUserTypeId) {
		repo.delete(whUserTypeId);
	}

	@Override
	public WhUserType getOneWhUserTypeId(long whUserTypeId) {
		WhUserType whUserType=(WhUserType)repo.getOne(whUserTypeId);
		return whUserType;
	}

	@Override
	public List<WhUserType> getAll() {
		List<WhUserType> whUserList=repo.findAll();
		Collections.sort(whUserList);
		return whUserList;
	}

	@Override
	public List<WhUserType> findByUserType(String userType) {
		return repo.findByUserType(userType);
	}

}
