package edu.mum.group3.dao;

import java.util.List;

import edu.mum.group3.model.ServiceLog;

public interface ServiceLogDao {

	public void addServiceLog(ServiceLog serviceLog);

	public List<ServiceLog> listServiceLogs();
	
	public ServiceLog getServiceLog(int serviceLogId);
	
	public void deleteServiceLog(ServiceLog serviceLog);
}
