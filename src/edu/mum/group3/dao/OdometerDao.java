package edu.mum.group3.dao;

import java.util.List;

import edu.mum.group3.model.Odometer;

/**
 * @author Lwin Moe Aung
 *
 */
public interface OdometerDao {

	public void addOdometer(Odometer odometer);

	public List<Odometer> listOdometers();

	public Odometer getOdometer(int odometerId);

	public void deleteOdometer(Odometer odometer);
}
