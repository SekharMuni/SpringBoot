package com.app.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.app.model.Uom;
import com.app.repo.UomRepository;
@Service
public class UomServiceImpl implements IUomService {
	@Autowired
	private UomRepository repo;

	@Override
	public long save(Uom uom) {
		uom.setCreatedDate(new Date());
		uom=(Uom) repo.save(uom);
		return uom.getUomId();
	}

	@Override
	public void update(Uom uom) 
	{
		uom.setCreatedDate(repo.getOne(uom.getUomId()).getCreatedDate());
		uom.setLastModifiedDate(new Date());
		repo.save(uom);
	}

	@Override
	public void deleteById(long uomId) {
		repo.delete(uomId);

	}

	@Override
	public Uom getOneById(long uomId) {
		Uom uom1=(Uom) repo.getOne(uomId);
		return uom1;
	}

	@Override
	public List<Uom> getAll() 
	{
		List<Uom> uomList=repo.findAll();
		Collections.sort(uomList);
		return uomList;
	}

	@Override
	public List<Uom> saveMultiple(List<Uom> uomList) {
		return repo.save(uomList);
	}

	@Override
	public Page<Uom> getAll(Specification<Uom> spec, Pageable pageable) {
		Page<Uom> uomList=(Page<Uom>)repo.findAll(pageable);
		return uomList;
	}

	@Override
	public boolean isUomTypeModelExist(Uom uom) {
		long count=repo.findUomCountByTypeAndModel(uom.getUomType(),uom.getUomModel());
		if(count==0)
			return false;
		else
			return true;
	}

}
