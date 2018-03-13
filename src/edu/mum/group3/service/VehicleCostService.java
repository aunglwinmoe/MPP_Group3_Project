package edu.mum.group3.service;

import java.util.List;

import edu.mum.group3.model.VehicleCost;

/**
 * @author Lwin Moe Aung
 *
 */
public interface VehicleCostService {

	public void addVehicleCost(VehicleCost vehicleCost);

	public List<VehicleCost> listVehicleCosts();

	public VehicleCost getVehicleCost(int vehicleCostId);

	public void deleteVehicleCost(VehicleCost vehicleCost);
}
