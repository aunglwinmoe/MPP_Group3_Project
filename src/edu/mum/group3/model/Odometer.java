package edu.mum.group3.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Lwin Moe Aung
 *
 */
@Entity
@Table(name = "Odometer")
public class Odometer implements Serializable {
	private static final long serialVersionUID = 7015311004920996397L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "odometerId")
	private Integer odometerId;

	@Column(name = "vehicleid")
	private Integer vehicleId;

	@Column(name = "odometerval")
	private double odometerVal;

	@Column(name = "date")
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date date;

	@Column(name = "status")
	private String status;

	@Column(name = "chkservice")
	private boolean chkService;

	@Column(name = "servicedate")
	private LocalDate serviceDate;

	public Integer getOdometerId() {
		return odometerId;
	}

	public void setOdometerId(Integer odometerId) {
		this.odometerId = odometerId;
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
