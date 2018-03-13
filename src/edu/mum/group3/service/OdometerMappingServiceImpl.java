package edu.mum.group3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.group3.dao.OdometerMappingDao;
import edu.mum.group3.model.OdometerMapping;

@Service("odometerMappingService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class OdometerMappingServiceImpl implements OdometerMappingService{
	
	@Autowired
	private OdometerMappingDao odometerMappintDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addOdometerMapping(OdometerMapping odometerMapping) {
		odometerMappintDao.addOdometerMapping(odometerMapping);
	}
	
	public List<OdometerMapping> listOdometerMappings() {
		return odometerMappintDao.listOdometerMappings();
	}

	public OdometerMapping getOdometerMapping(int odometerMappingId) {
		return odometerMappintDao.getOdometerMapping(odometerMappingId);
	}
	
	public void deleteOdometerMapping(OdometerMapping odometerMapping) {
		odometerMappintDao.deleteOdometerMapping(odometerMapping);
	}
}
