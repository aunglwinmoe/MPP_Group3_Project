package edu.mum.group3.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.group3.model.FuelLog;

/**
 * @author Lwin Moe Aung
 *
 */
@Repository("fuelLogDao")
public class FuelLogDaoImpl implements FuelLogDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addFuelLog(FuelLog fuelLog) {
		sessionFactory.getCurrentSession().saveOrUpdate(fuelLog);
	}

	@SuppressWarnings("unchecked")
	public List<FuelLog> listFuelLogs() {
		return (List<FuelLog>) sessionFactory.getCurrentSession().createCriteria(FuelLog.class).list();
	}

	public FuelLog getFuelLog(int fuelLogId) {
		return (FuelLog) sessionFactory.getCurrentSession().get(FuelLog.class, fuelLogId);
	}

	public void deleteFuelLog(FuelLog fuelLog) {
		sessionFactory.getCurrentSession()
				.createQuery("DELETE FROM FuelLog WHERE fuellogid = " + fuelLog.getFuelLogId()).executeUpdate();
	}

}
