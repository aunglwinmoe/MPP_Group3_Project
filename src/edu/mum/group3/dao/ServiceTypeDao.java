package edu.mum.group3.dao;

import java.util.List;

import edu.mum.group3.model.ServiceType;

public interface ServiceTypeDao {

	public void addServiceType(ServiceType serviceType);

	public List<ServiceType> listServiceTypes();
	
	public ServiceType getServiceType(int serviceTypeId);
	
	public void deleteServiceType(ServiceType serviceType);
}
