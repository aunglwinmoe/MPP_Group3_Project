package edu.mum.group3.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.group3.model.VehicleCost;

@Repository("vehicleCostDao")
public class VehicleCostDaoImpl implements VehicleCostDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addVehicleCost(VehicleCost vehicleCost) {
		sessionFactory.getCurrentSession().saveOrUpdate(vehicleCost);
	}

	@SuppressWarnings("unchecked")
	public List<VehicleCost> listVehicleCosts() {
		return (List<VehicleCost>) sessionFactory.getCurrentSession().createCriteria(VehicleCost.class).list();
	}

	public VehicleCost getVehicleCost(int vehicleCostId) {
		return (VehicleCost) sessionFactory.getCurrentSession().get(VehicleCost.class, vehicleCostId);
	}

	public void deleteVehicleCost(VehicleCost vehicleCost) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM VehicleCost WHERE vehiclecostid = " + vehicleCost.getVehicleCostId())
				.executeUpdate();
	}

}
