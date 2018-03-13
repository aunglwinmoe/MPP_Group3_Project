package edu.mum.group3.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "VehicleCost")
public class VehicleCost implements Serializable {

	private static final long serialVersionUID = -7888023238961014718L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vehiclecostid")
	private Integer vehicleCostId;

	@Column(name = "totalPrice")
	private double totalPrice;

	@Column(name = "costDesc")
	private String costDesc;

	@Column(name = "date")
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date date;

	@Column(name = "vehicleid")
	private Integer vehicleId;
	
	@Column(name = "servicetypeid")
	private Integer serviceTypeId;
	
	
	public Integer getVehicleCostId() {
		return vehicleCostId;
	}

	public void setVehicleCostId(Integer vehicleCostId) {
		this.vehicleCostId = vehicleCostId;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getCostDesc() {
		return costDesc;
	}

	public void setCostDesc(String costDesc) {
		this.costDesc = costDesc;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Integer getServiceTypeId() {
		return serviceTypeId;
	}

	public void setServiceTypeId(Integer serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}

}
