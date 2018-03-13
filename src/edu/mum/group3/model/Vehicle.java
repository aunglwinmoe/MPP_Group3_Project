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
@Table(name = "Vehicle")
public class Vehicle implements Serializable {

	private static final long serialVersionUID = -6473120616622782043L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vehicleid")
	private Integer vehicleId;

	@Column(name = "vehiclename")
	private String vehicleName;
	
	@Column(name = "modelid")
	private Integer modelId;

	@Column(name = "licenseplate")
	private String licensePlate;

	@Column(name = "chassisnumber")
	private String chassisNumber;

	@Column(name = "modelyear")
	private String modelYear;

	@Column(name = "lastodometer")
	private double lastOdometer;

	@Column(name = "immatriculationdate")
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date immatriculationDate;

	@Column(name = "catalogval")
	private double catalogVal;

	@Column(name = "residualval")
	private double residualVal;

	@Column(name = "seatsnum")
	private int seatsNum;

	@Column(name = "doorsnum")
	private int doorsNum;

	@Column(name = "color")
	private String color;

	@Column(name = "transmission")
	private String transmission;

	@Column(name = "fueltype")
	private String fuelType;

	@Column(name = "horsepower")
	private int horsePower;

	@Column(name = "power")
	private String power;

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public Integer getModelId() {
		return modelId;
	}

	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getChassisNumber() {
		return chassisNumber;
	}

	public void setChassisNumber(String chassisNumber) {
		this.chassisNumber = chassisNumber;
	}

	public String getModelYear() {
		return modelYear;
	}

	public void setModelYear(String modelYear) {
		this.modelYear = modelYear;
	}

	public double getLastOdometer() {
		return lastOdometer;
	}

	public void setLastOdometer(double lastOdometer) {
		this.lastOdometer = lastOdometer;
	}

	public Date getImmatriculationDate() {
		return immatriculationDate;
	}

	public void setImmatriculationDate(Date immatriculationDate) {
		this.immatriculationDate = immatriculationDate;
	}

	public double getCatalogVal() {
		return catalogVal;
	}

	public void setCatalogVal(double catalogVal) {
		this.catalogVal = catalogVal;
	}

	public double getResidualVal() {
		return residualVal;
	}

	public void setResidualVal(double residualVal) {
		this.residualVal = residualVal;
	}

	public int getSeatsNum() {
		return seatsNum;
	}

	public void setSeatsNum(int seatsNum) {
		this.seatsNum = seatsNum;
	}

	public int getDoorsNum() {
		return doorsNum;
	}

	public void setDoorsNum(int doorsNum) {
		this.doorsNum = doorsNum;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public int getHorsePower() {
		return horsePower;
	}

	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

}
