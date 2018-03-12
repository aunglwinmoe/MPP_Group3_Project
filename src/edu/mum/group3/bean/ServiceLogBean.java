package edu.mum.group3.bean;

import java.time.LocalDate;
import java.util.Date;

public class ServiceLogBean {
	 private Integer id;
	 private Integer vehicleId;
	 private String vehicleName;
	 private Integer serviceTypeId;
	 private String serviceTypeName;
	 private double totalPrice;
	 private double odometerVal;
	 private Date date;
	 private Integer vendorId;
	 private String vendorName;
	 private String invoiceRef;
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
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public Integer getServiceTypeId() {
		return serviceTypeId;
	}
	public void setServiceTypeId(Integer serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}
	public String getServiceTypeName() {
		return serviceTypeName;
	}
	public void setServiceTypeName(String serviceTypeName) {
		this.serviceTypeName = serviceTypeName;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
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
	public Integer getVendorId() {
		return vendorId;
	}
	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getInvoiceRef() {
		return invoiceRef;
	}
	public void setInvoiceRef(String invoiceRef) {
		this.invoiceRef = invoiceRef;
	}
}
