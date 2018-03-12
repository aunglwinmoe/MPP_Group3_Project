package edu.mum.group3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.group3.dao.FuelLogDao;
import edu.mum.group3.model.FuelLog;

/**
 * @author Lwin Moe Aung
 *
 */
@Service("fuelLogService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class FuelLogServiceImpl implements FuelLogService {

	@Autowired
	private FuelLogDao fuelLogDao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addFuelLog(FuelLog fuelLog) {
		fuelLogDao.addFuelLog(fuelLog);
	}

	public List<FuelLog> listFuelLogs() {
		return fuelLogDao.listFuelLogs();
	}

	public FuelLog getFuelLog(int fuelLogId) {
		return fuelLogDao.getFuelLog(fuelLogId);
	}

	public void deleteFuelLog(FuelLog fuelLog) {
		fuelLogDao.deleteFuelLog(fuelLog);
	}

}
