package edu.mum.group3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.group3.dao.VehicleDao;
import edu.mum.group3.model.Vehicle;

/**
 * @author Lwin Moe Aung
 *
 */
@Service("vehicleService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleDao vehicleDao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addVehicle(Vehicle vehicle) {
		vehicleDao.addVehicle(vehicle);
	}

	public List<Vehicle> listVehicles() {
		return vehicleDao.listVehicles();
	}

	public Vehicle getVehicle(int vehicleId) {
		return vehicleDao.getVehicle(vehicleId);
	}

	public void deleteVehicle(Vehicle vehicle) {
		vehicleDao.deleteVehicle(vehicle);
	}

}
