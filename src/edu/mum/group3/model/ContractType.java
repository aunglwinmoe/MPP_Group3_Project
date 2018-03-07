package edu.mum.group3.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "ContractType")
public class ContractType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1435914677851538345L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "contracttypeid")
	private Integer contractTypeId;

	@Column(name = "contracttypename")
	private String contractTypeName;

	public Integer getContractTypeId() {
		return contractTypeId;
	}

	public void setContractTypeId(Integer contractTypeId) {
		this.contractTypeId = contractTypeId;
	}

	public String getContractTypeName() {
		return contractTypeName;
	}

	public void setContractTypeName(String contractTypeName) {
		this.contractTypeName = contractTypeName;
	}

	
}
