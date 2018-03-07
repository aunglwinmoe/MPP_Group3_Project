package edu.mum.group3.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ServiceLog implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5796468198455442647L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "modelid")
	private Integer modelId;

	@Column(name = "modelname")
	private String modelName;
}
