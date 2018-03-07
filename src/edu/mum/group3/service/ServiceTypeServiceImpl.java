package edu.mum.group3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.group3.dao.ServiceTypeDao;
import edu.mum.group3.model.ServiceType;

@Service("serviceTypeService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ServiceTypeServiceImpl implements ServiceTypeService{
	
	@Autowired
	private ServiceTypeDao serviceTypeDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addServiceType(ServiceType serviceType) {
		serviceTypeDao.addServiceType(serviceType);
	}
	
	public List<ServiceType> listServiceTypes() {
		return serviceTypeDao.listServiceTypes();
	}

	public ServiceType getServiceType(int serviceTypeId) {
		return serviceTypeDao.getServiceType(serviceTypeId);
	}
	
	public void deleteServiceType(ServiceType serviceType) {
		serviceTypeDao.deleteServiceType(serviceType);
	}
}
