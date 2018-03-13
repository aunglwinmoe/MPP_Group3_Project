package edu.mum.group3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.group3.dao.VehicleCostDao;
import edu.mum.group3.model.VehicleCost;

/**
 * @author Lwin Moe Aung
 *
 */
@Service("vehicleCostCostService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class VehicleCostServiceImpl implements VehicleCostService {

	@Autowired
	private VehicleCostDao vehicleCostDao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addVehicleCost(VehicleCost vehicleCost) {
		vehicleCostDao.addVehicleCost(vehicleCost);
	}

	public List<VehicleCost> listVehicleCosts() {
		return vehicleCostDao.listVehicleCosts();
	}

	public VehicleCost getVehicleCost(int vehicleCostId) {
		return vehicleCostDao.getVehicleCost(vehicleCostId);
	}

	public void deleteVehicleCost(VehicleCost vehicleCost) {
		vehicleCostDao.deleteVehicleCost(vehicleCost);
	}

}
