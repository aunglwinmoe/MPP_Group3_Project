package edu.mum.group3.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ServiceType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2917093299756622691L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "servicetypeid")
	private Integer serviceTypeId;

	@Column(name = "servicetypename")
	private String serviceTypeName;

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
	
	
}
