package edu.mum.group3.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Model implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 92114636366031561L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "modelid")
	private Integer modelId;

	@Column(name = "modelname")
	private String modelName;

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

	

}
