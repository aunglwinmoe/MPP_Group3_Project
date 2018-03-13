package edu.mum.group3.bean;

import java.util.List;

public class OdometerMappingBean {
	private Integer id;
	private double maxOdometer;
	private List<VehicleBean> vehicleList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getMaxOdometer() {
		return maxOdometer;
	}

	public void setMaxOdometer(double maxOdometer) {
		this.maxOdometer = maxOdometer;
	}

	public List<VehicleBean> getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(List<VehicleBean> vehicleList) {
		this.vehicleList = vehicleList;
	}

}
