package edu.mum.group3.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.group3.model.ServiceLog;

@Repository("serviceLogDao")
public class ServiceLogDaoImpl implements ServiceLogDao{

	@Autowired
	private SessionFactory sessionFactory;

	public void addServiceLog(ServiceLog serviceLog) {
		sessionFactory.getCurrentSession().saveOrUpdate(serviceLog);
	}

	@SuppressWarnings("unchecked")
	public List<ServiceLog> listServiceLogs() {
		return (List<ServiceLog>) sessionFactory.getCurrentSession().createCriteria(ServiceLog.class).list();
	}

	public ServiceLog getServiceLog(int serviceLogId) {
		return (ServiceLog) sessionFactory.getCurrentSession().get(ServiceLog.class, serviceLogId);
	}

	public void deleteServiceLog(ServiceLog serviceLog) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM ServiceLog WHERE logid = " + serviceLog.getLogId())
				.executeUpdate();
	}
}
