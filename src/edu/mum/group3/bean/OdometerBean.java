package edu.mum.group3.bean;

import java.time.LocalDate;
import java.util.Date;

public class OdometerBean {
	private Integer id;
	private Integer vehicleId;
	private double odometerVal;
	private Date date;
	private String status;
	private boolean chkService;
	private LocalDate serviceDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public double getOdometerVal() {
		return odometerVal;
	}

	public void setOdometerVal(double odometerVal) {
		this.odometerVal = odometerVal;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean getChkService() {
		return chkService;
	}

	public void setChkService(boolean chkService) {
		this.chkService = chkService;
	}

	public LocalDate getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(LocalDate serviceDate) {
		this.serviceDate = serviceDate;
	}

}
