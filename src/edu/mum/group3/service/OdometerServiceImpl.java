package edu.mum.group3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.group3.dao.OdometerDao;
import edu.mum.group3.model.Odometer;

/**
 * @author Lwin Moe Aung
 *
 */
@Service("OdometerService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class OdometerServiceImpl implements OdometerService {

	@Autowired
	private OdometerDao odometerDao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addOdometer(Odometer odometer) {
		odometerDao.addOdometer(odometer);
	}

	public List<Odometer> listOdometers() {
		return odometerDao.listOdometers();
	}

	public Odometer getOdometer(int odometerId) {
		return odometerDao.getOdometer(odometerId);
	}

	public void deleteOdometer(Odometer odometer) {
		odometerDao.deleteOdometer(odometer);
	}

}
