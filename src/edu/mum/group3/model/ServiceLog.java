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

@Entity
@Table(name = "ServiceLog")
public class ServiceLog implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5796468198455442647L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "logid")
	private Integer logId;
	
	@Column(name = "vehicleid")
	private Integer vehicleId;
	
	@Column(name = "servicetypeid")
	private Integer serviceTypeId;

	@Column(name = "totalprice")
	private double totalPrice;
	
	@Column(name = "odometerval")
	private double odometerVal;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "vendorid")
	private Integer vendorId;
	
	@Column(name = "invoiceref")
	private String invoiceRef;

	
	public Integer getLogId() {
		return logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
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

	public String getInvoiceRef() {
		return invoiceRef;
	}

	public void setInvoiceRef(String invoiceRef) {
		this.invoiceRef = invoiceRef;
	}

	
}
