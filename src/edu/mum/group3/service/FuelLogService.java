package edu.mum.group3.service;

import java.util.List;

import edu.mum.group3.model.FuelLog;

/**
 * @author Lwin Moe Aung
 *
 */
public interface FuelLogService {

	public void addFuelLog(FuelLog fuelLog);

	public List<FuelLog> listFuelLogs();

	public FuelLog getFuelLog(int fuelLogId);

	public void deleteFuelLog(FuelLog fuelLog);
}
