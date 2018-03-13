package edu.mum.group3.bean;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author Lwin Moe Aung
 *
 */
public class VehicleBean {
	private Integer id;
	private String vehicleName;
	private Integer modelId;
	private String modelName;
	private String licensePlate;
	private String chassisNumber;
	private String modelYear;
	private double lastOdometer;
	private Date immatriculationDate;
	private double catalogVal;
	private double residualVal;
	private int seatsNum;
	private int doorsNum;
	private String color;
	private String transmission;
	private String fuelType;
	private int horsePower;
	private String power;
	private String status;
	private double limitedOdometer;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getLimitedOdometer() {
		return limitedOdometer;
	}

	public void setLimitedOdometer(double limitedOdometer) {
		this.limitedOdometer = limitedOdometer;
	}

}
