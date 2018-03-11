package edu.mum.group3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.group3.dao.ServiceLogDao;
import edu.mum.group3.model.ServiceLog;

@Service("serviceLogService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ServiceLogServiceImpl implements ServiceLogService{

	@Autowired
	private ServiceLogDao serviceLogDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addServiceLog(ServiceLog serviceLog) {
		serviceLogDao.addServiceLog(serviceLog);
	}
	
	public List<ServiceLog> listServiceLogs() {
		return serviceLogDao.listServiceLogs();
	}

	public ServiceLog getServiceLog(int serviceLogId) {
		return serviceLogDao.getServiceLog(serviceLogId);
	}
	
	public void deleteServiceLog(ServiceLog serviceLog) {
		serviceLogDao.deleteServiceLog(serviceLog);
	}
}
