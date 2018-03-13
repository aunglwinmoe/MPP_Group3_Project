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
@Table(name = "FuelLog")
public class FuelLog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6846689632976401976L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fuellogid")
	private Integer fuelLogId;

	@Column(name = "vehicleid")
	private Integer vehicleId;

	@Column(name = "liter")
	private double liter;

	@Column(name = "priceperliter")
	private double pricePerLiter;

	@Column(name = "totalprice")
	private double totalPrice;

	@Column(name = "date")
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date date;

	@Column(name = "invoicereference")
	private String invoiceReference;

	@Column(name = "otherinfo")
	private String otherInfo;

	@Column(name = "vendorid")
	private Integer vendorId;

	@Column(name = "purchaserid")
	private Integer purchaserId;

	public Integer getFuelLogId() {
		return fuelLogId;
	}

	public void setFuelLogId(Integer fuelLogId) {
		this.fuelLogId = fuelLogId;
	}

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public double getLiter() {
		return liter;
	}

	public void setLiter(double liter) {
		this.liter = liter;
	}

	public double getPricePerLiter() {
		return pricePerLiter;
	}

	public void setPricePerLiter(double pricePerLiter) {
		this.pricePerLiter = pricePerLiter;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getInvoiceReference() {
		return invoiceReference;
	}

	public void setInvoiceReference(String invoiceReference) {
		this.invoiceReference = invoiceReference;
	}

	public String getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

	public Integer getVendorId() {
		return vendorId;
	}

	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	public Integer getPurchaserId() {
		return purchaserId;
	}

	public void setPurchaserId(Integer purchaserId) {
		this.purchaserId = purchaserId;
	}
}
