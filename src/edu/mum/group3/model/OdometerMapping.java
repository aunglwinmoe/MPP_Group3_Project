package edu.mum.group3.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "OdometerMapping")
public class OdometerMapping implements Serializable {

	private static final long serialVersionUID = 9147628391554885258L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "odometermappingid")
	private Integer odometerMappingId;

	@Column(name = "maxodometer")
	private double maxOdometer;

//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name="vehicleid")
//	private List<Vehicle> vehicleList;

	public Integer getOdometerMappingId() {
		return odometerMappingId;
	}

	public void setOdometerMappingId(Integer odometerMappingId) {
		this.odometerMappingId = odometerMappingId;
	}

	public double getMaxOdometer() {
		return maxOdometer;
	}

	public void setMaxOdometer(double maxOdometer) {
		this.maxOdometer = maxOdometer;
	}

//	public List<Vehicle> getVehicleList() {
//		return vehicleList;
//	}
//
//	public void setVehicleList(List<Vehicle> vehicleList) {
//		this.vehicleList = vehicleList;
//	}

}
