package edu.mum.group3.dao;

import java.util.List;

import edu.mum.group3.model.Vehicle;

/**
 * @author Lwin Moe Aung
 *
 */
public interface VehicleDao {

	public void addVehicle(Vehicle vehicle);

	public List<Vehicle> listVehicles();

	public Vehicle getVehicle(int vehicleId);

	public void deleteVehicle(Vehicle vehicle);
}
