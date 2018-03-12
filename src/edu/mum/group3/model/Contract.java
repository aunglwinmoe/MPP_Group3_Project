package edu.mum.group3.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Lwin Moe Aung
 *
 */
@Entity
@Table(name = "Contract")
public class Contract implements Serializable {

	private static final long serialVersionUID = 803714949718639942L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "contractid")
	private Integer contractId;

	@Column(name = "vehicleid")
	private Integer vehicleId;

	@Column(name = "contracttypeid")
	private Integer contractTypeId;

	@Column(name = "odometeratcreation")
	private double odometerAtCreation;

	@Column(name = "invoicedate")
	private LocalDate invoiceDate;

	@Column(name = "contractstartdate")
	private LocalDate contractStartDate;

	@Column(name = "contractexpdate")
	private LocalDate contractExpDate;

	@Column(name = "contractorid")
	private Integer contractorId;

	@Column(name = "vendorid")
	private Integer vendorId;

	@Column(name = "rentalcost")
	private double rentalCost;

	@Column(name = "termsandconditions")
	private String termsAndConditions;

	public Integer getContractId() {
		return contractId;
	}

	public void setContractId(Integer contractId) {
		this.contractId = contractId;
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
