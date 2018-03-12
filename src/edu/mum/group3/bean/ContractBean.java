package edu.mum.group3.bean;

import java.time.LocalDate;

public class ContractBean {
	private Integer id;
	private Integer vehicleId;
	private Integer contractTypeId;
	private double odometerAtCreation;
	private LocalDate invoiceDate;
	private LocalDate contractStartDate;
	private LocalDate contractExpDate;
	private Integer contractorId;
	private Integer vendorId;
	private double rentalCost;
	private String termsAndConditions;

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

	public Integer getContractTypeId() {
		return contractTypeId;
	}

	public void setContractTypeId(Integer contractTypeId) {
		this.contractTypeId = contractTypeId;
	}

	public double getOdometerAtCreation() {
		return odometerAtCreation;
	}

	public void setOdometerAtCreation(double odometerAtCreation) {
		this.odometerAtCreation = odometerAtCreation;
	}

	public LocalDate getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(LocalDate invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public LocalDate getContractStartDate() {
		return contractStartDate;
	}

	public void setContractStartDate(LocalDate contractStartDate) {
		this.contractStartDate = contractStartDate;
	}

	public LocalDate getContractExpDate() {
		return contractExpDate;
	}

	public void setContractExpDate(LocalDate contractExpDate) {
		this.contractExpDate = contractExpDate;
	}

	public Integer getContractorId() {
		return contractorId;
	}

	public void setContractorId(Integer contractorId) {
		this.contractorId = contractorId;
	}

	public Integer getVendorId() {
		return vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public double getRentalCost() {
		return rentalCost;
	}

	public void setRentalCost(double rentalCost) {
		this.rentalCost = rentalCost;
	}

	public String getTermsAndConditions() {
		return termsAndConditions;
	}

	public void setTermsAndConditions(String termsAndConditions) {
		this.termsAndConditions = termsAndConditions;
	}

}
