package edu.mum.group3.dao;

import java.util.List;

import edu.mum.group3.model.FuelLog;

/**
 * @author Lwin Moe Aung
 *
 */
public interface FuelLogDao {

	public void addFuelLog(FuelLog fuelLog);

	public List<FuelLog> listFuelLogs();

	public FuelLog getFuelLog(int fuelLogId);

	public void deleteFuelLog(FuelLog fuelLog);
}
