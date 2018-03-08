package edu.mum.group3.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.group3.model.Vehicle;

/**
 * @author Lwin Moe Aung
 *
 */
@Repository("vehicleDao")
public class VehicleDaoImpl implements VehicleDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addVehicle(Vehicle vehicle) {
		sessionFactory.getCurrentSession().saveOrUpdate(vehicle);
	}

	@SuppressWarnings("unchecked")
	public List<Vehicle> listVehicles() {
		return (List<Vehicle>) sessionFactory.getCurrentSession().createCriteria(Vehicle.class).list();
	}

	public Vehicle getVehicle(int vehicleId) {
		return (Vehicle) sessionFactory.getCurrentSession().get(Vehicle.class, vehicleId);
	}

	public void deleteVehicle(Vehicle vehicle) {
		sessionFactory.getCurrentSession()
				.createQuery("DELETE FROM Vehicle WHERE vehicleid = " + vehicle.getVehicleId()).executeUpdate();
	}

}
