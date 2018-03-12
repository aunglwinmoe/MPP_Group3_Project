package edu.mum.group3.service;

import java.util.List;

import edu.mum.group3.model.ServiceLog;

public interface ServiceLogService {

	public void addServiceLog(ServiceLog serviceLog);

	public List<ServiceLog> listServiceLogs();
	
	public ServiceLog getServiceLog(int serviceLogId);
	
	public void deleteServiceLog(ServiceLog serviceLog);
}
