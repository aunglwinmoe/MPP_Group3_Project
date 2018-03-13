package edu.mum.group3.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.group3.model.OdometerMapping;

@Repository("odometerMappingDao")
public class OdometerMappingDaoImpl implements OdometerMappingDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addOdometerMapping(OdometerMapping odometerMapping) {
		sessionFactory.getCurrentSession().saveOrUpdate(odometerMapping);
	}

	@SuppressWarnings("unchecked")
	public List<OdometerMapping> listOdometerMappings() {
		return (List<OdometerMapping>) sessionFactory.getCurrentSession().createCriteria(OdometerMapping.class).list();
	}

	public OdometerMapping getOdometerMapping(int odometerMappingId) {
		return (OdometerMapping) sessionFactory.getCurrentSession().get(OdometerMapping.class, odometerMappingId);
	}

	public void deleteOdometerMapping(OdometerMapping odometerMapping) {
		sessionFactory.getCurrentSession().createQuery(
				"DELETE FROM OdometerMapping WHERE odometermappingid = " + odometerMapping.getOdometerMappingId())
				.executeUpdate();
	}
}
