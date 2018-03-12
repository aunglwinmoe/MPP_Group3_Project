package edu.mum.group3.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.mum.group3.model.Odometer;

/**
 * @author Lwin Moe Aung
 *
 */
@Repository("odometerDao")
public class OdometerDaoImpl implements OdometerDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addOdometer(Odometer odometer) {
		sessionFactory.getCurrentSession().saveOrUpdate(odometer);
	}

	@SuppressWarnings("unchecked")
	public List<Odometer> listOdometers() {
		return (List<Odometer>) sessionFactory.getCurrentSession().createCriteria(Odometer.class).list();
	}

	public Odometer getOdometer(int odometerId) {
		return (Odometer) sessionFactory.getCurrentSession().get(Odometer.class, odometerId);
	}

	public void deleteOdometer(Odometer Odometer) {
		sessionFactory.getCurrentSession()
				.createQuery("DELETE FROM Odometer WHERE odometerid = " + Odometer.getOdometerId()).executeUpdate();
	}

}
