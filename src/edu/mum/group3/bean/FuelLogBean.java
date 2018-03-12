package edu.mum.group3.bean;

import java.time.LocalDate;

/**
 * @author Lwin Moe Aung
 *
 */
public class FuelLogBean {

	private Integer id;
	private Integer vehicleId;
	private double liter;
	private double pricePerLiter;
	private double totalPrice;
	private LocalDate date;
	private String invoiceReference;
	private String otherInfo;
	private Integer vendorId;
	private Integer purchaserId; // remove

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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
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
