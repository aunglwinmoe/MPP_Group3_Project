package edu.mum.group3.dao;

import java.util.List;

import edu.mum.group3.model.VehicleCost;

public interface VehicleCostDao {
	
	public void addVehicleCost(VehicleCost vehicleCost);

	public List<VehicleCost> listVehicleCosts();
	
	public VehicleCost getVehicleCost(int vehicleCostId);
	
	public void deleteVehicleCost(VehicleCost vehicleCost);
	
}