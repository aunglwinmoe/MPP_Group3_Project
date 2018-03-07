package edu.mum.group3.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.group3.model.ServiceType;

@Repository("serviceTypeDao")
public class ServiceTypeDaoImpl implements ServiceTypeDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addServiceType(ServiceType serviceType) {
		sessionFactory.getCurrentSession().saveOrUpdate(serviceType);
	}

	@SuppressWarnings("unchecked")
	public List<ServiceType> listServiceTypes() {
		return (List<ServiceType>) sessionFactory.getCurrentSession().createCriteria(ServiceType.class).list();
	}

	public ServiceType getServiceType(int serviceTypeId) {
		return (ServiceType) sessionFactory.getCurrentSession().get(ServiceType.class, serviceTypeId);
	}

	public void deleteServiceType(ServiceType serviceType) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM ServiceType WHERE servicetypeid = " + serviceType.getServiceTypeId())
				.executeUpdate();
	}
}
