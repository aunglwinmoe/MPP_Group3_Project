package edu.mum.group3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.group3.dao.MakeDao;
import edu.mum.group3.model.Make;

@Service("makeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MakeServiceImpl implements MakeService{
	
	@Autowired
	private MakeDao makeDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addMake(Make make) {
		makeDao.addMake(make);
	}
	
	public List<Make> listMakes() {
		return makeDao.listMakes();
	}

	public Make getMake(int makeId) {
		return makeDao.getMake(makeId);
	}
	
	public void deleteMake(Make make) {
		makeDao.deleteMake(make);
	}
}
